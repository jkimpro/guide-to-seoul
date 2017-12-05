/**
 * WebPageOpen.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.awt.Desktop; 

public class WebPageOpen {			
	
	public WebPageOpen(String address, String name)				// �ּ�, �̸� Parameter�� �ް� ������ ����
	{
		try 
		{
			Desktop.getDesktop().browse(new URI("http://www.google.com/search?q=" + URLEncoder.encode(address, "UTF-8") + "+" +	//������ ���� �� google �˻� �ǽ�
			URLEncoder.encode(name, "UTF-8"))); 
		}
		catch (Exception e) 
		{ e.printStackTrace(); }	

	}
	
}
