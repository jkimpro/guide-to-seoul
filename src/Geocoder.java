/**
 * Geocoder.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;

public class Geocoder
{
	private String lat;								//���� ���� ����
	private String lng;								//�浵 ���� ����
	public Geocoder(String userLocation)			//����� ��ġ�� ������
	{
		lat ="";
		lng ="";
		
		try
		{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	//���۸��� ��ü ���� �� ����
			    String latLongs[] = getLatLongPositions(userLocation);							//���� �浵 �ӽ� ���� �迭 ���� �� �ʱ�ȭ getLetLongPositions�� ���� ���� �浵�� ����/
			    lat = latLongs[0];					//���� ����
			    lng = latLongs[1];					//�浵 ����
			    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  
  
  public static String[] getLatLongPositions(String address) throws Exception			
  {
    int responseCode = 0;
    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";	//api ������ ����� ��ġ�� ��� URL �ּ� ����
    URL url = new URL(api);
    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();														//�������� ����
    httpConnection.connect();																										//�� ����
    responseCode = httpConnection.getResponseCode();																				//���� �ڵ� ����
    
    //responseCode�� 200 �ϋ� google �� xml ������ ������ �޾Ҵٴ� ��.
    if(responseCode == 200)
    {
    	//������ ���� ����
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
      Document document = builder.parse(httpConnection.getInputStream());
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
      String status = (String)expr.evaluate(document, XPathConstants.STRING);
      
      //���� �浵 ���� ��� ��û �� Local�� �μ� �޴� ����.
      if(status.equals("OK"))
      {
         expr = xpath.compile("//geometry/location/lat");
         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
         expr = xpath.compile("//geometry/location/lng");
         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
    
         return new String[] {latitude, longitude};
      }
      else	//���н� ���� �޼���
      {
         throw new Exception("Error from the API - response status: "+status);
      }
    }
    return null;
  }
  public void setLocation(String location)																//����� ��ġ ����� ����ϴ� �޼ҵ� (�����ڿ� ����)
  {
	  	lat ="";
		lng ="";	
		try
		{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			    String latLongs[] = getLatLongPositions(location);
			    System.out.println(latLongs[0] + latLongs[1]);
			    lat = latLongs[0];
			    lng = latLongs[1];
			    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
  }
  public String getLng()			//���� ��ȯ
  {
	  return lng;
  }
  public String getLat()			//�浵 ��ȯ
  {
	  return lat;
  }

}