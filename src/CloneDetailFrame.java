/**
 * CloneDetailFrame.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��s
 * ���� ������: 2017�� 12�� 7��
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserCommandEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserListener;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowOpeningEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowWillOpenEvent;


public class CloneDetailFrame extends JFrame{
	
	private JLabel detailBar = new JLabel(new ImageIcon(Main.class.getResource("images/detailInfoBar.png")));				//detailInfoFrame �޴��� �� ����
	private ImageIcon detailExitButtonEnteredImage = new ImageIcon(Main.class.getResource("images/exitButtonEntered.png"));	//detailInfoFrame ������ ��ư Hover �̹��� ��ü ����
	private ImageIcon detailExitButtonBasicImage = new ImageIcon(Main.class.getResource("images/exitButtonBasic.png"));		//detailInfoFrame ������ ��ư �⺻ �̹��� ��ü ����
	private ImageIcon searchButtonBasicImage = new ImageIcon(Main.class.getResource("images/searchBasic.png"));				//detailInfoFrame ���� ��� ��ư �⺻ �̹��� ��ü ����
	private ImageIcon searchButtonEnteredImage = new ImageIcon(Main.class.getResource("images/searchEntered.png"));			//detailInfoFrame ���� ��� ��ư Hover �̹��� ��ü ����
	private ImageIcon internetBasic = new ImageIcon(Main.class.getResource("images/internetButtonBasic.png"));				//detailInfoFrame �� ���� ��ư �⺻ �̹��� ��ü ����
	private ImageIcon internetEntered = new ImageIcon(Main.class.getResource("images/internetButtonEntered.png"));			//detailInfoFrame �� ���� ��ư Hover �̹��� ��ü ����
	
	
	private JPanel subPanel;							// primary �г� �޴��� �κ��� ������ ��� frame �κ��� ���� �г�
	private JPanel subInfo;								// subPanel �� ���� �ϴ� �� �ٿ��� �г�
	private Javascript javascript;						// Javascript ��ü ����
	private JButton connectInternetButton;				// ���ͳ� ���� ��ư ��ü ����
	
	//�� ����
	private JLabel name;								//detailInfo �̸�
	private JLabel address;								//detailInfo �ּ�
	private JLabel Lat;									//detailInfo ����
	private JLabel Lng;									//detailInfo �浵
	private JLabel phoneNum;							//detailInfo ��ȭ��ȣ
	private JLabel menu;								//detailInfo �޴�
	private JLabel subject;								//detailInfo ī�װ�
	private JLabel level;								//detailInfo ȣ�� ��� 
	private JLabel distanceLabel;						//detailInfo �Ÿ� ��� ��
	
	
	private JButton detailExitButton;					//������ ��ư ����
	private JButton executeJavascriptButton;			//���� ��� ��ư ����
	
	private int mouseX, mouseY;							//���콺 ��ġ ���� ����
	
	private String options;								//detailInfo 4���׸� �� 1���� ������ ����
	private int index;									//�׸� �ش��ϴ� ������ �ε��� ���� ������ ����
	
  protected static final String LS = System.getProperty("line.separator");		//html ���� ���� ��ɾ�
  public CloneDetailFrame(String option, int ind, double distance)
  {

	  options = option;
	  index = ind;
	  
	  //��ü �г� ���� �� �ɼ� ����
	  subPanel = new JPanel();
	  subPanel.setLayout(null);
	  subPanel.setBounds(0,30,700,700);
	  subPanel.setBackground(new Color(255,200,0));
	  
	  //���� �г� ���� �� �ɼ� ����
	  subInfo = new JPanel();
	  subInfo.setLayout(null);
	  subInfo.setBounds(10,450,680,300);
	  subInfo.setBackground(new Color(255,200,0));
	  
	  //�̸� �� ���� �� �ɼ� ����
	  name = new JLabel();
	  name.setBounds(0,0,680,20);
	  name.setFont(new Font("�������", Font.BOLD, 20));
	  name.setForeground(Color.black);
	
	  //�ּ� �� ���� �� �ɼ� ����
	  address= new JLabel();
	  address.setBounds(0,25,680,20);
	  address.setFont(new Font("�������", Font.BOLD, 20));
	  address.setForeground(Color.black);
	  
	  //���� �� ���� �� �ɼ� ����
	  Lat= new JLabel();
	  Lat.setBounds(0,50,680,20);
	  Lat.setFont(new Font("�������", Font.BOLD, 20));
	  Lat.setForeground(Color.black);
	
	  //�浵 �� ���� �� �ɼ� ����
	  Lng = new JLabel();
	  Lng.setBounds(0,75,680,20);
	  Lng.setFont(new Font("�������", Font.BOLD, 20));
	  Lng.setForeground(Color.black);

	  //��ȭ��ȣ �� ���� �� �ɼ� ����
	  phoneNum= new JLabel();
	  phoneNum.setBounds(0,100,680,20);
	  phoneNum.setFont(new Font("�������", Font.BOLD, 20));
	  phoneNum.setForeground(Color.black);
	  
	  //ȣ�� ��� �� ���� �� �ɼ� ����
	  level= new JLabel();
	  level.setBounds(0,125,680,20);
	  level.setFont(new Font("�������", Font.BOLD, 20));
	  level.setForeground(Color.black);
	   
	  //�Ĵ� ī�װ� �� ���� �� �ɼ� ����
	  subject= new JLabel();
	  subject.setBounds(0,125,680,20);
	  subject.setFont(new Font("�������", Font.BOLD, 20));
	  subject.setForeground(Color.black);
	  
	  //�Ĵ� �ָ޴� �� ���� �� �ɼ� ����
	  menu= new JLabel();
	  menu.setBounds(0,150,680,20);
	  menu.setFont(new Font("�������", Font.BOLD, 20));
	  menu.setForeground(Color.black);
	  
	  //�Ÿ� ��¶� ���� �� �ɼ� ����
	  distanceLabel= new JLabel("Distance: "+ distance + " KM");
	  distanceLabel.setBounds(0,220,680,20);
	  distanceLabel.setFont(new Font("�������", Font.BOLD, 20));
	  distanceLabel.setForeground(Color.black);
	  
		
	if(option == "Hospital")							//�ɼ��� ������ ���
	  {
		//������ �ش��ϴ� ���� ���� �� �󺧿� ������ subInfo �гο� �߰�
		name.setText("Name: " + Hospital.hospitalName[ind]);
		address.setText("Address: " +Hospital.hospitalAddress[ind]);
		Lat.setText("Latitude(����): " + Hospital.hospitalLA[ind]);
		Lng.setText("Longitude(�浵): " + Hospital.hospitalLO[ind]);
		
		subInfo.add(name);
		subInfo.add(address);
		subInfo.add(Lat);
		subInfo.add(Lng);
		
	  }
	  else if(option == "Road")							//�ɼ��� ���� ����
	  {

		//�濡 �ش��ϴ� ���� ���� �� �󺧿� ������ subInfo �гο� �߰�
		  name.setText("Name: " + Road.roadName[ind]);
		  address.setText("Address: " +Road.roadAddress[ind]);
		  Lat.setText("Latitude(����): " + Road.roadLA[ind]);
		  Lng.setText("Longitude(�浵): " + Road.roadLO[ind]);
		  subInfo.add(name);
			subInfo.add(address);
			subInfo.add(Lat);
			subInfo.add(Lng);
			
	  }
	  else if(option == "Restaurant")					//�ɼ��� �Ĵ��� ���
	  {
		//�Ĵ翡 �ش��ϴ� ���� ���� �� �󺧿� ������ subInfo �гο� �߰�
		  name.setText("Name: " + Restaurant.restaurantName[ind]);
		  address.setText("Address: " +Restaurant.restaurantAddress[ind]);
		  Lat.setText("Latitude(����): " + Restaurant.restaurantLA[ind]);
		  Lng.setText("Longitude(�浵): " + Restaurant.restaurantLO[ind]);
		  phoneNum.setText("Phone Number: "+ Restaurant.restaurantPhoneNum[ind]);
		  subject.setText("ī�װ�: " + Restaurant.restaurantSubject[ind]);
		  menu.setText("�ָ޴�: " + Restaurant.restaurantMenu[ind]);
		  subInfo.add(name);
		  subInfo.add(address);
		  subInfo.add(Lat);
		  subInfo.add(Lng);
		  subInfo.add(phoneNum);
		  subInfo.add(subject);
		  subInfo.add(menu);
	  }
	  else if(option == "Hotel")						//�ɼ��� ȣ���� ���
	  {

		//ȣ�ڿ� �ش��ϴ� ���� ���� �� �󺧿� ������ subInfo �гο� �߰�
		  name.setText("Name: " + Hotel.hotelName[ind]);
		  address.setText("Address: " +Hotel.hotelAddress[ind]);
		  Lat.setText("Latitude(����): " + Hotel.hotelLA[ind]);
		  Lng.setText("Longitude(�浵): " + Hotel.hotelLO[ind]);
		  phoneNum.setText("Phone Number: "+ Hotel.hotelNum[ind]);
		  level.setText("Hotel Level: " + Hotel.hotelPrice[ind]);
		  subInfo.add(name);
		  subInfo.add(address);
		  subInfo.add(Lat);
		  subInfo.add(Lng);
		  subInfo.add(phoneNum);
		  subInfo.add(level);
	  }
	  subInfo.add(distanceLabel);					//������ �Ÿ���� �󺧵� subInfo�� �߰�
	  
	    NativeInterface.open();						//���� �߰� �۾� �ǽ�
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	    	  
	    	//ClonDetailFrame �� �⺻ �ɼ� ����
	    	setUndecorated(true);
	    	setSize(700, 730);
	        setLocationByPlatform(true);
	        setVisible(true);
	        setResizable(false);
	        setLayout(null);
	        
	        //������ ��ư �ɼ� �ʱ�ȭ �� �̺�Ʈ ����
			detailExitButton = new JButton(detailExitButtonBasicImage);
			detailExitButton.setBounds(670,0,30,30);
			detailExitButton.setBorderPainted(false);
			detailExitButton.setContentAreaFilled(false);
			detailExitButton.setFocusPainted(false);
			detailExitButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseEntered(MouseEvent e)
				{
					detailExitButton.setIcon(detailExitButtonEnteredImage);
					detailExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e)
				{
					detailExitButton.setIcon(detailExitButtonBasicImage);
					detailExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
				}
				@Override
				public void mousePressed(MouseEvent e)
				{
					dispose();									//������ ��ư�� ������ ��� �ش� frame �ݱ�
				}
			});
			add(detailExitButton);								//frame�� ������ ��ư �߰�
				
	        createContent();									//���� ���� �۾� �Լ�
	        subPanel.add(subInfo);
	        add(subPanel);
	        
	        detailBar.setBounds(0,0,700,30);					//�޴��� ��ġ ����
			detailBar.addMouseListener(new MouseAdapter()		//�޴��� �̺�Ʈ ����
			{
				//�޴��ٸ� ��� �������� �� ��ü �����ӵ� �����̰� ����
				@Override
					public void mousePressed(MouseEvent e)
					{
						mouseX = e.getX();
						mouseY = e.getY();
					}
			});
			detailBar.addMouseMotionListener(new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent e)
				{
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					setLocation(x - mouseX, y - mouseY);
				}
			});
			add(detailBar);
		

	      }
	    });
	    
	}
	public void createContent() {
	    
		JPanel webBrowserPanel = new JPanel(new BorderLayout());					//������ ����� �г� ���� �� �ʱ�ȭ
		webBrowserPanel.setBounds(10,10,680,430);									//�г� ũ�� ����
		
	    final JWebBrowser webBrowser = new JWebBrowser();							//�������� ��ü ����
	    webBrowser.setBarsVisible(false);
	    webBrowser.setStatusBarVisible(true);
	    final String htmlContent =
	      "<html>" + LS +
	      "<head>" + LS +
	      "<style>\r\n"  + LS +
	      "body {background-image: url(\"https://i.ytimg.com/vi/7Uvmww35oxw/maxresdefault.jpg\");\r\n"  + LS +
	      "      background-repeat: no-repeat;\r\n"  + LS +
	      "      background-attachment: fixed;\r\n"  + LS +
	      "      background-position: right bottom;}\r\n"  + LS +
	      "table, td {background-color: transparent;} \r\n"  + LS + 
	      "</style>" + LS +
	      "	</head>" + LS +
	      "  <body>" + LS +
	      "   <div id = \"map\"> <font size=30, color = white> <center> Loading... </center> </font> </div>" + LS +
	      "  </body>" + LS +
	      "</html>";
	    
	    webBrowser.addWebBrowserListener(new WebBrowserListener(){
			public void commandReceived(WebBrowserCommandEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void loadingProgressChanged(WebBrowserEvent arg0) {
			}
			public void locationChangeCanceled(WebBrowserNavigationEvent arg0) {
			}
			public void locationChanged(WebBrowserNavigationEvent arg0) {						//�������� ���� ��ġ�� �ٲ���� ��
				javascript = new Javascript();													//�ڹ� ��ũ��Ʈ ��ü ����
				if(options == "Hospital")														//������ ��� ���� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Hospital.hospitalLA[index],Hospital.hospitalLO[index]);
				}
				else if(options == "Road")														//���� ��� �� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Road.roadLA[index],Road.roadLO[index]);			
				}
				
				else if(options == "Restaurant")												//�Ĵ��� ��� �Ĵ� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Restaurant.restaurantLA[index],Restaurant.restaurantLO[index]);			
				}
				else if(options == "Hotel")														//ȣ���� ��� ȣ�� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Hotel.hotelLA[index],Hotel.hotelLO[index]);					
				}
				webBrowser.executeJavascript(javascript.getScript());
			}
			public void locationChanging(WebBrowserNavigationEvent arg0) {
			}
			public void statusChanged(WebBrowserEvent arg0) {
			}
			public void titleChanged(WebBrowserEvent arg0) {
			}
			public void windowClosing(WebBrowserEvent arg0) {
			}
			public void windowOpening(WebBrowserWindowOpeningEvent arg0) {
			}
			public void windowWillOpen(WebBrowserWindowWillOpenEvent arg0) {
			}
	    	
	    });
	    webBrowser.setHTMLContent(htmlContent);	
	    webBrowserPanel.add(webBrowser);													//���������� ���� �г�(webBrowserPanel)�� ���̱�
	    subPanel.add(webBrowserPanel);														//subPanel �� ���� �г� ���̱�
	   
	    
	    //���� ��� ��ư �ʱ�ȭ �� �ɼ� ����
	    executeJavascriptButton = new JButton(searchButtonBasicImage);
	    executeJavascriptButton.setLayout(null);
	    executeJavascriptButton.setBorderPainted(false);
	    executeJavascriptButton.setBounds(580,190,50,50);									//��ư��ġ ������ �ϴ� ù���� ����
		executeJavascriptButton.setHorizontalAlignment(SwingConstants.CENTER);
	    executeJavascriptButton.addMouseListener(new MouseAdapter() {						//���� ��� ��ư�� ���õ� ���콺 �̺�Ʈ
	    
	    	public void mouseEntered(MouseEvent e)											//���콺 Hover�� �̹��� ��ȭ
	    	{
	    		executeJavascriptButton.setIcon(searchButtonEnteredImage);
	    	}
	    	public void mouseExited(MouseEvent e)											//���콺 Exit�� �⺻�̹����� ��ȭ
	    	{
	    		executeJavascriptButton.setIcon(searchButtonBasicImage);
	    	}
	    	public void mouseReleased(MouseEvent e) {										//���콺 Ŭ����
	    			
				javascript = new Javascript();												//�ڹ� ��ũ��Ʈ ��ü ����
				if(options == "Hospital")													//������ ��� ���� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Hospital.hospitalLA[index],Hospital.hospitalLO[index]);
				}
				else if(options == "Road")													//���� ��� �� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Road.roadLA[index],Road.roadLO[index]);			
				}
				
				else if(options == "Restaurant")											//�Ĵ��� ��� �Ĵ� �����Ϳ� �ش��ϴ����� ��������
				{
					javascript.setDetailMain(Restaurant.restaurantLA[index],Restaurant.restaurantLO[index]);			
				}
				else if(options == "Hotel")													//ȣ���� ��� ȣ�� �����Ϳ� �ش��ϴ� ���� ���� ����
				{
					javascript.setDetailMain(Hotel.hotelLA[index],Hotel.hotelLO[index]);					
				}
				webBrowser.executeJavascript(javascript.getScript());						//�������� ����
	      }
	    });
	    
	    //���ͳ� ���� ��ư �ʱ�ȭ �� �ɼ� ����
	    connectInternetButton = new JButton(internetBasic);
	    connectInternetButton.setBorderPainted(false);
	    connectInternetButton.setBounds(630,190,50,50);										//��ư��ġ ������ �ϴ� �ι��� ����
	    connectInternetButton.setHorizontalAlignment(SwingConstants.CENTER);
	    connectInternetButton.addMouseListener(new MouseAdapter() {							//���ͳ� ����� ���õ� ���콺 �̺�Ʈ
	    	public void mouseEntered(MouseEvent e)											//���콺 Hover�� �̹��� ��ȭ
	    	{
	    		connectInternetButton.setIcon(internetEntered);
	    	}
	    	public void mouseExited(MouseEvent e)											//���콺 Exit�� �⺻ �̹����� ��ȭ
	    	{
	    		connectInternetButton.setIcon(internetBasic);
	    	}
	    	public void mouseReleased(MouseEvent e) {										//���콺 Ŭ����
	    		
				if(options == "Hospital")															//������ ���
				{
					new WebPageOpen(Hospital.hospitalAddress[index],Hospital.hospitalName[index]);	//���� �ּҿ� �̸��� �Ű������� �������� ���ͳ� ������ ����
				}
				else if(options == "Road")															//���� ���
				{
					new WebPageOpen(Road.roadAddress[index],Road.roadName[index]);					//�� �ּҿ� �̸��� �Ű������� �������� ���ͳ� ������ ����
				}
				
				else if(options == "Restaurant")													//�Ĵ��� ���
				{
					new WebPageOpen(Restaurant.restaurantAddress[index],Restaurant.restaurantName[index]);	//�Ĵ� �ּҿ� �̸��� �Ű������� �������� ���ͳ� ������ ����
				}
				else if(options == "Hotel")															//ȣ���� ���
				{
					new WebPageOpen(Hotel.hotelAddress[index],Hotel.hotelName[index]);				//ȣ�� �ּҿ� �̸��� �Ű������� �������� ���ͳ� ������ ����
				}
	      }
	    });
	  
	    //subInfo �гο� ������� ��ư�� ���ͳ� ���� ��ư �߰�
	    subInfo.add(executeJavascriptButton);														
	    subInfo.add(connectInternetButton);
	}
}