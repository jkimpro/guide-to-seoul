/**
 * DetailObject.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DetailObject {
	private JButton detailButton;														//DetailInfo.class�� �г�(GuideToSeoul.class�� ���� �г�)�� �� ��ư ��ü ����
	private JLabel name;																//�̸� ��ü ����
	private JLabel address;																//�ּ� ��ü ����
	private JLabel details;																//���� ���� ��ü ����
	private CloneDetailFrame cloneFrame;												//��ư Ŭ���� ���ο� �������� �����ϱ� ���� ��ü ����
	
	public DetailObject() {
		detailButton = new JButton();													//��ư �ʱ�ȭ
		detailButton.setPreferredSize(new Dimension(200,120));							//��ư ������ ����
		name = new JLabel();
		address = new JLabel();
		details = new JLabel();
	}
	public DetailObject(String option, String name, String address, String details, int index, double distance) {
		
		detailButton = new JButton();
		detailButton.setLayout(new BorderLayout());										//��ư layout ����
		detailButton.setPreferredSize(new Dimension(200,120));							//��ư ������ ����
		this.name = new JLabel(name);													//�̸� Label ���� �� �ɼ� ����
		this.name.setFont(new Font("Gothic", Font.BOLD, 20));
		this.address = new JLabel(address);												//�ּ� �� ����
		this.details = new JLabel(details);												//�������� �� ����
		detailButton.setBackground(new Color(255,248,230));
		
		detailButton.add(BorderLayout.NORTH,this.name);									//�̸� ��ư ��� ��ġ
		detailButton.add(BorderLayout.CENTER,this.address);								//�ּ� ��ư �߾� ��ġ
		detailButton.add(BorderLayout.SOUTH,this.details);								//�������� ��ư �ϴ� ��ġ
		detailButton.addMouseListener(new MouseAdapter(){								//��ư ���콺 �̺�Ʈ �߰�
				
				public void mouseEntered(MouseEvent e)
				{
					detailButton.setBackground(Color.orange);							//��ư Hover�� �÷� ��ȭ
				}
				public void mouseExited(MouseEvent e)
				{
					detailButton.setBackground(new Color(255,248,230));	
				}
				@Override
				public void mouseReleased(MouseEvent e)
				{
					new CloneDetailFrame(option, index, distance);						//��ư Ŭ���� ���� ����frame ���� 
				}
		});
	}
	public JButton getDetailButton() {													//��ư ��ȯ
		return detailButton;
	}
	public JLabel getName() {															//�̸� ��ȯ
		return name;
	}
	public JLabel getAddress() {														//�ּ� ��ȯ
		return address;
	}
	public JLabel getDetails() {														//�������� ��ȯ
		return details;
	}
	public void setName(String name) {													//�̸� ����
		this.name.setText(name);
		this.name.setFont(new Font("Gothic", Font.BOLD, 20));
	}
	public void setAddress(String address) {											//�ּ� ����
		this.address.setText(address);
		this.address.setFont(new Font("Gothic", Font.BOLD, 14));
	}
	public void setDetails(String details) {											//�������� ����
		this.details.setText(details);
		this.details.setFont(new Font("Gothic", Font.BOLD, 14));
	}
}
