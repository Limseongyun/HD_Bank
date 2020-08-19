package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.HDCardVO;

@Repository
public class HDPayDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	//ī�� ����
	public void addCard(HDCardVO card) {
		ss.insert("hdpay.addCard",card);
	}
	
	//ī�� ����
	public void delCard(int card_num) {
		ss.delete("hdpay.delCard",card_num);
	}
	
	//ī����������Ʈ ��ȸ
	public List<String> listCardType(int mem_code) {
		return ss.selectList("hdpay.cardType", mem_code);
		
	}
	
	//ī�� ������(ī���ȣ, �ܾ� ��ȸ)
	public HDCardVO cardDetail(String card_type) {
		return ss.selectOne("hdpay.cardNumBal", card_type);	
	}
}
