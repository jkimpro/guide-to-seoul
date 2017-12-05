/**
 * DetailInfo.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class DetailInfo extends JFrame {
	
	private JPanel detailInfoPanel;														//GuideToSeoul ���� �гη� ���� �г� ��ü ����
	private ArrayList<DetailObject> objectList;											//DetailObject ���� ������ ��ư���� ���� ArrayList ����
	
	public DetailInfo() {
		
		detailInfoPanel = new JPanel();													//�г� ��ü �ʱ�ȭ
		detailInfoPanel.setBackground(Color.white);
		detailInfoPanel.setLayout(new GridLayout(Restaurant.restaurantName.length,1));	//�г� Layout ����
		objectList = new ArrayList<DetailObject>();										//objectList �ʱ�ȭ
	}
	public void setDetailContents(String Contents, double myLat, double myLng) {		//����ڿ��� �Ÿ��� ����Ͽ� ��ư ������ �߰��� �̷����
		objectList.clear();																//objectList ���� ��� �����
		
		if(Contents == "Restaurant")													//�Ĵ� �ɼ�
			for(int i=0; i<Restaurant.restaurantCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//�Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Restaurant.restaurantLA[i]), Double.parseDouble(Restaurant.restaurantLO[i]), "kilometer");	
				if(distanceKiloMeter<5)		//�Ÿ��� 5km������ ��� ����Ʈ�� �߰�
				{
				objectList.add(new DetailObject("Restaurant",Restaurant.restaurantName[i],Restaurant.restaurantPhoneNum[i],Restaurant.restaurantAddress[i], i,distanceKiloMeter));
	  	   
				}
	  	    }
		
		if(Contents == "Hotel")															//ȣ�� �ɼ�
			for(int i=0; i<Hotel.hotelCount; i++)
	  	    {	
				double distanceKiloMeter =0;
				//�Ÿ� ���
	  	    	distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hotel.hotelLA[i]), Double.parseDouble(Hotel.hotelLO[i]), "kilometer");	
	  	    	if(distanceKiloMeter<5)//�Ÿ��� 5km������ ��� ����Ʈ�� �߰�
				{
				objectList.add(new DetailObject("Hotel",Hotel.hotelName[i],Hotel.hotelAddress[i],"", i,distanceKiloMeter));
	  	   
				}
	  	    }
		
		if(Contents == "Road")															//�� �ɼ�
			for(int i=0; i<Road.roadCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//�Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Road.roadLA[i]), Double.parseDouble(Road.roadLO[i]), "kilometer");	
		  	  	if(distanceKiloMeter<5)//�Ÿ��� 5km������ ��� ����Ʈ�� �߰�
				{	
		  	  		objectList.add(new DetailObject("Road",Road.roadName[i],Road.roadAddress[i],"", i,distanceKiloMeter));
				}
	  	    }
		
		if(Contents == "Hospital")														//���� �ɼ�
			for(int i=0; i<Hospital.hospitalCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//�Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hospital.hospitalLA[i]), Double.parseDouble(Hospital.hospitalLO[i]), "kilometer");	
	  	    	if(distanceKiloMeter<5)//�Ÿ��� 5km������ ��� ����Ʈ�� �߰�
				{
	  	    		objectList.add(new DetailObject("Hospital",Hospital.hospitalName[i],Hospital.hospitalAddress[i],"", i,distanceKiloMeter));
				}
	  	    }
	}
	
	public void setLabelPos() {
		detailInfoPanel.removeAll();													//���� �гο� �����ִ� ��� ������ ����
		for(int i=1; i<objectList.size(); i++)											//List �� �ִ� ��ư���� ���������� �гο� ����.
  	    {
			detailInfoPanel.add(objectList.get(i).getDetailButton());
  	    }
	}
	public void setInitial()															//Panel �� objectList �ʱ�ȭ
	{
		objectList.clear();
		detailInfoPanel.removeAll();	
	}
	
	public JPanel getPanel() {															//Panel ��ȯ
		return detailInfoPanel;
	}
	
	
}
