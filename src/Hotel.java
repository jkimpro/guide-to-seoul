/**
 * Hotel.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */
public class Hotel {
	
	public static int hotelCount = 26;								//ȣ���Ѱ���
	public static String [] hotelName = new String[200];			//ȣ�� �̸�
	public static String [] hotelAddress = new String[200];			//ȣ�� �ּ�
	public static String [] hotelLO=new String[200];				//ȣ�� �浵
	public static String [] hotelLA=new String[200];				//ȣ�� ����
	public static String [] hotelPrice = new String[200];			//ȣ�� ���
	public static String [] hotelNum = new String[200];				//ȣ�� ��ȭ��ȣ
	
	public Hotel()													//ȣ�� ������ �� �ϵ� �ڵ� �ǽ�.
	{
		hotelName[0] = "�Ե� ȣ�� ����";
		hotelAddress[0] ="���� �߱� ������";
		hotelLO[0] = "126.9809";
		hotelLA[0] = "37.5653";
		hotelPrice[0] = "5����";
		hotelNum[0] = "02-771-1000";
		
		hotelName[1] = "ȣ�� �̺� �ڹ輭�� ��";
		hotelAddress[1] ="���� �߱� �� ���빮�� 78";
		hotelLO[1] = "126.982750";
		hotelLA[1] = "37.564191";
		hotelPrice[1] = "3����";
		hotelNum[1] = "02-6361-8888";
		
		
		hotelName[2] = "�Ŷ����� ��ȭ��";
		hotelAddress[2] ="����Ư���� ���α� ���۵� �����4�� 63";
		hotelLO[2] = "126.981081";
		hotelLA[2] = "37.572758";
		hotelPrice[2] = "4����";
		hotelNum[2] = "02-6060-9000";
		
		hotelName[3] = "������ ȣ�� ����";
		hotelAddress[3] ="����Ư���� ���α� ������ �����ȷ� 97";
		hotelLO[3] = "126.975453";
		hotelLA[3] = "37.570465";
		hotelPrice[3] = "5����";
		hotelNum[3] = "02-6388-5000";
		
		hotelName[4] = "ȣ�� ���� ����";
		hotelAddress[4] ="����Ư���� ���α� ����1.2.3.4���� ���ϴ�� 401-8";
		hotelLO[4] = "126.987024";
		hotelLA[4] = "37.570537";
		hotelPrice[4] = "3����";
		hotelNum[4] = "02-723-0284";
		
		hotelName[5] = "�������� ȣ�� ���� ��";
		hotelAddress[5] ="����Ư���� �߱� �� ���� 115";
		hotelLO[5] = "126.984531";
		hotelLA[5] = "37.561227";
		hotelPrice[5] = "4����";
		hotelNum[5] = "02-6936-6000";
		
		hotelName[6] = "��������Ʈ ȣ��";
		hotelAddress[6] ="����Ư���� �߱� ��������Ʈȣ��";
		hotelLO[6] = "126.979431";
		hotelLA[6] = "37.565643";
		hotelPrice[6] = "4����";
		hotelNum[6] = "02-753-3131";
		
		hotelName[7] = "�ع��� ȣ��";
		hotelAddress[7] ="����Ư���� ��걸 ���¿�1�� ���¿��� 179";
		hotelLO[7] = "126.993674";
		hotelLA[7] = "37.534853";
		hotelPrice[7] = "3����";
		hotelNum[7] = "02-6393-1000";
		
		hotelName[8] = "���Ǹ��� �Ӹ��� ��Ƽũ ȣ��";
		hotelAddress[8] ="����Ư���� ��걸 �ѳ��� 737-32";
		hotelLO[8] = "126.998260";
		hotelLA[8] = "37.535333";
		hotelPrice[8] = "4����";
		hotelNum[8] = "02-3702-8000";
		
		hotelName[9] = "�׷��� �Ͼ�Ʈ ����";
		hotelAddress[9] ="����Ư���� ��걸 ���¿�2�� �ҿ��� 322";
		hotelLO[9] = "126.997104";
		hotelLA[9] = "37.539348";
		hotelPrice[9] = "5����";
		hotelNum[9] = "02-797-1234";
		
		hotelName[10] = "���� �Ŷ�ȣ��";
		hotelAddress[10] ="����Ư���� �߱� ���浿2�� ��ȣ�� 249";
		hotelLO[10] = "127.006232";
		hotelLA[10] = "37.556460";
		hotelPrice[10] = "5����";
		hotelNum[10] = "02-2233-3131";
		
		hotelName[11] = "������ȣ��";
		hotelAddress[11] ="����Ư���� ������ ���ǵ� 595";
		hotelLO[11] = "127.091862";
		hotelLA[11] = "37.534124";
		hotelPrice[11] = "3����";
		hotelNum[11] = "02-455-1100";
		
		hotelName[12] = "����ȣ��";
		hotelAddress[12] ="����Ư���� �߱� �� ���� 145";
		hotelLO[12] = " 126.987941";
		hotelLA[12] = "37.561312";
		hotelPrice[12] = "4����";
		hotelNum[12] = "02-773-6000";
		
		hotelName[13] = "�̺� ��Ÿ�� �ڹ輭�� ���� ��";
		hotelAddress[13] ="����Ư���� �߱� �� ���ϴ�� 302";
		hotelLO[13] = "126.989206";
		hotelLA[13] = "37.561798";
		hotelPrice[13] = "4����";
		hotelNum[13] = "02-6370-1101";
		
		hotelName[14] = "����ȣ��";
		hotelAddress[14] ="����Ư���� �������� ���ǵ��� 13-18";
		hotelLO[14] = "126.920456";
		hotelLA[14] = "37.530331";
		hotelPrice[14] = "3����";
		hotelNum[14] = "02-783-2233";
		
		hotelName[15] = "ȣ�� �뺸�� �ڹ輭�� ����";
		hotelAddress[15] ="����Ư���� ������ ����1�� ������� 130";
		hotelLO[15] = "127.028899";
		hotelLA[15] = "37.505242";
		hotelPrice[15] = "5����";
		hotelNum[15] = "02-567-1101";
		
		hotelName[16] = "���޸���� ���� ȣ��";
		hotelAddress[16] ="����Ư���� ������ ����1�� ������� 120";
		hotelLO[16] = "127.027170";
		hotelLA[16] = "37.504856";
		hotelPrice[16] = "5����";
		hotelNum[16] = "02-3451-8000";
		
		hotelName[17] = "JW�޸���Ʈȣ�� ����";
		hotelAddress[17] ="176 Sinbanpo-ro, ����4�� Seocho-gu, Seoul";
		hotelLO[17] = "127.004624";
		hotelLA[17] = "37.503789";
		hotelPrice[17] = "5����";
		hotelNum[17] = "02-6282-6262";
		
		hotelName[18] = "Sheraton Seoul PaLOce Gangnam hotel";
		hotelAddress[18] ="Seoul ����Ư���� Seoul ����4�� 160 Sapyeong-daero Seocho-gu";
		hotelLO[18] = "127.001653";
		hotelLA[18] = "37.500857";
		hotelPrice[18] = "5����";
		hotelNum[18] = "02-532-5000";
		
		hotelName[19] = "��Ŭ���� ȣ��";
		hotelAddress[19] ="����Ư���� ���ʱ� ����4�� ������58�� 12";
		hotelLO[19] = "127.023730";
		hotelLA[19] = "37.503055";
		hotelPrice[19] = "4����";
		hotelNum[19] = "1899-9994";
		
		hotelName[20] = "��ũ �Ͼ�Ʈ ����";
		hotelAddress[20] ="����Ư���� ������ ��ġ2�� ������� 606";
		hotelLO[20] = "127.064111";
		hotelLA[20] = "37.508501";
		hotelPrice[20] = "5����";
		hotelNum[20] = "02-2016-1234";
		
		hotelName[21] = "�׷��� ������Ƽ��Ż ���� �ĸ�����";
		hotelAddress[21] ="521 Teheran-ro, �Ｚ1�� Gangnam-gu, Seoul";
		hotelLO[21] = "127.060755";
		hotelLA[21] = "37.509177";
		hotelPrice[21] = "5����";
		hotelNum[21] = "02-555-5656";
		
		hotelName[22] = "ȣ�� ������ �Ｚ hotel PEYTO SAMSEONG";
		hotelAddress[22] ="����Ư���� ������ �Ｚ1�� �������87�� 9";
		hotelLO[22] = "127.058688";
		hotelLA[22] = "37.508385";
		hotelPrice[22] = "4����";
		hotelNum[22] = "02-6936-9700";
		
		hotelName[23] = "�Ե�ȣ�ڿ���";
		hotelAddress[23] ="����Ư���� ���ı� ���3�� �ø��ȷ� 240";
		hotelLO[23] = "127.099873";
		hotelLA[23] = "37.511493";
		hotelPrice[23] = "4����";
		hotelNum[23] = "02-419-7000";
		
		hotelName[24] = "�Ե���Ƽȣ�� ����";
		hotelAddress[24] ="����Ư���� ������ ������ ������� 109";
		hotelLO[24] = "126.950493";
		hotelLA[24] = "37.544696";
		hotelPrice[24] = "4����";
		hotelNum[24] = "02-6009-1000";
		
		hotelName[25] = "Nine Tree Premier hotel Myeongdong II";
		hotelAddress[25] ="����Ư���� �߱� �ʵ� �������� 28";
		hotelLO[25] = "126.990763";
		hotelLA[25] = "37.564318";
		hotelPrice[25] = "4����";
		hotelNum[25] ="02-6967-0999";
		
	}
	
}
