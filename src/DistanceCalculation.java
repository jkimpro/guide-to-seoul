/**
 * DistanceCalculation.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */
public class DistanceCalculation {
	
	/*
	 �Ÿ� ����� ���� ���� �� �浵 ���� 2���� �ް�, �ɼ��� �޽��ϴ�. ���⼭ ����ϴ� �ɼ��� km ���� �̸� meter ���� �� �����մϴ�.
	 ��ü���� ��� ������ 
	 
	 http://www.geodatasource.com/developers/java
	 http://transition.fcc.gov/mb/audio/bickel/DDDMMSS-decimal.html
	 http://egloos.zum.com/metashower/v/313035
	 
	 �� �����Ͻñ� �ٶ��ϴ�.
	 */
	 public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {	
	      
		  	double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + 
	        		Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	         
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        dist = dist * 60 * 1.1515;
	      
	        if (unit == "kilometer") {
	            dist = dist * 1.609344;
	        } else if(unit == "meter"){
	            dist = dist * 1609.344;
	        }
	 	
	        return (dist);
	  }
	  public static double deg2rad(double deg) {
	      return (double)(deg * Math.PI / (double)180.0d);
	  }
	   
	  public static double rad2deg(double rad) {
	      return (double)(rad * (double)180d / Math.PI);
	  }
}
