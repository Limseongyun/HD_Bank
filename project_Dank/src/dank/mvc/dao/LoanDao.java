//<<<<<<< HEAD
//<<<<<<< HEAD
package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.FilenameVO;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;
import dank.mvc.vo.LoanRepayLogVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.deposit.AccountVO;


@Repository
public class LoanDao {
	@Autowired
	private SqlSessionTemplate ss;
	//��ȣ��
	//�����ǰ����
	public List<LoanProductVO> getLoanProductList(){
		return ss.selectList("loan.product");
	}
	//�����ǰ������
	public LoanProductVO getProductInfo(int lp_num) {
		return ss.selectOne("loan.productinfo", lp_num);
	}
	//�����û(���������Է�)
	public void insertLoanCheck(LoanCheckVO vo) {
		ss.insert("loan.check", vo);
	}
	//�����û(�����û�����Է�)
	public void insertLoanApllication(LoanApplicationVO avo) {
		ss.insert("loan.application", avo);
	}
	//��û���� ����Ʈ
	public List<LoanCheckVO> checkdetailList(int mem_code) {
		return ss.selectList("loan.checkdetaillist",mem_code);
	}
	//��û���� ������
	public LoanCheckVO checkdetail(LoanCheckVO vo) {
		return ss.selectOne("loan.checkdetail",vo);
	}

	//������� ����
	public void stateupdate(int lc_num) {
		ss.update("loan.stateupdate",lc_num);
	}
	//���� ������ ���� Ȩ
	public LoanFileVO fileuploadhome(int mem_code) {
		return ss.selectOne("loan.fileuploadhome",mem_code);
	}

	//���� ����(���� ���� ����)
	public void loanstart(int lc_num) {
		ss.update("loan.loanstart", lc_num);
	}
	//���� ����(���� ��ȯ ���� �Է�)
	public void loanrepaystart(LoanRepayVO vo) {
		ss.insert("loan.loanrepay", vo);
	}
	//���� ��ȯ ���� ���ݰ��� ��������
	public List<AccountVO> repayaccount(int mem_code) {
		return ss.selectList("loan.selectaccount",mem_code);
	}
	//���� ��ȯ�ϱ�
	public void repayloan(LoanRepayVO vo) {
		ss.update("loan.repayloan",vo);
	}  
	//���� ��ȯ  �α�
	public void repaylog(LoanRepayLogVO vo) {
		ss.insert("loan.repaylog", vo);
	}
	public int balance(int lc_num) {
		return ss.selectOne("loan.balance",lc_num);
	}
	public void loanend(int lc_num) {
		ss.update("loan.end",lc_num);
		
	}
	
	public List<FilenameVO> filelist(){
		return ss.selectList("loan.filename");
	}
	
	public void fileup(LoanFileVO vo) {
		ss.insert("loan.fileup",vo);
	}
	
	public List<LoanFileVO> filelist(int lc_num){
		return ss.selectList("loan.checkfiledetail",lc_num);
	}
	
	public String checkstate(int lc_num) {
		return ss.selectOne("loan.checkstate",lc_num);
	}
}
//=======
//package dank.mvc.dao;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import dank.mvc.vo.LoanApplicationVO;
//import dank.mvc.vo.LoanCheckVO;
//import dank.mvc.vo.LoanFileVO;
//import dank.mvc.vo.LoanProductVO;
//import dank.mvc.vo.LoanRepayVO;
//import dank.mvc.vo.deposit.AccountVO;
//
//
//@Repository
//public class LoanDao {
//	@Autowired
//	private SqlSessionTemplate ss;
//	
//	public List<LoanProductVO> getLoanProductList(){
//		return ss.selectList("loan.product");
//	}
//	
//	public LoanProductVO getProductInfo(int lp_num) {
//		return ss.selectOne("loan.productinfo", lp_num);
//	}
//	
//	public void insertLoanCheck(LoanCheckVO vo) {
//		ss.insert("loan.check", vo);
//	}
//	public void insertLoanApllication(LoanApplicationVO avo) {
//		ss.insert("loan.application", avo);
//	}
//	public List<LoanCheckVO> checkdetailList(int mem_code) {
//		return ss.selectList("loan.checkdetaillist",mem_code);
//	}
//	
//	public LoanCheckVO checkdetail(LoanCheckVO vo) {
//		return ss.selectOne("loan.checkdetail",vo);
//	}
//	
//	public void fileupload(LoanFileVO vo) {
//		ss.insert("loan.fileupload", vo);
//	}
//	public void refileupload(LoanFileVO vo) {
//		ss.update("loan.refileupload", vo);
//	}
//	
//	public void stateupdate(int lc_num) {
//		ss.update("loan.stateupdate",lc_num);
//	}
//	public LoanFileVO fileuploadhome(int mem_code) {
//		return ss.selectOne("loan.fileuploadhome",mem_code);
//	}
//	public LoanFileVO filedetail(int lc_num) {
//		return ss.selectOne("loan.filedetail",lc_num);
//	}
//	public void loanstart(int lc_num) {
//		ss.update("loan.loanstart", lc_num);
//	}
//	public void loanrepaystart(LoanRepayVO vo) {
//		ss.insert("loan.loanrepay", vo);
//	}
//	public List<AccountVO> repayaccount(int mem_code) {
//		return ss.selectList("loan.selectaccount",mem_code);
//	}
//	public void loanmoneyexport(int lr_amount) {
//		ss.update("loan.loanmoneyexport", lr_amount);
//	}
//	public void loanmoneyimport(LoanRepayVO vo) {
//		ss.update("loan.loanmoneyimport", vo);
//	}
//
//	public void repayloan(LoanRepayVO vo) {
//		ss.update("loan.repayloan",vo);
//	}  
//
//}
//>>>>>>> branch 'hov2' of https://github.com/wlsgb/HD_Bank.git
//=======
//package dank.mvc.dao;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import dank.mvc.vo.FilenameVO;
//import dank.mvc.vo.LoanApplicationVO;
//import dank.mvc.vo.LoanCheckVO;
//import dank.mvc.vo.LoanFileVO;
//import dank.mvc.vo.LoanFileVO;
//import dank.mvc.vo.LoanProductVO;
//import dank.mvc.vo.LoanRepayLogVO;
//import dank.mvc.vo.LoanRepayVO;
//import dank.mvc.vo.deposit.AccountVO;
//
//
//@Repository
//public class LoanDao {
//	@Autowired
//	private SqlSessionTemplate ss;
//	//��ȣ��
//	//�����ǰ����
//	public List<LoanProductVO> getLoanProductList(){
//		return ss.selectList("loan.product");
//	}
//	//�����ǰ������
//	public LoanProductVO getProductInfo(int lp_num) {
//		return ss.selectOne("loan.productinfo", lp_num);
//	}
//	//�����û(���������Է�)
//	public void insertLoanCheck(LoanCheckVO vo) {
//		ss.insert("loan.check", vo);
//	}
//	//�����û(�����û�����Է�)
//	public void insertLoanApllication(LoanApplicationVO avo) {
//		ss.insert("loan.application", avo);
//	}
//	//��û���� ����Ʈ
//	public List<LoanCheckVO> checkdetailList(int mem_code) {
//		return ss.selectList("loan.checkdetaillist",mem_code);
//	}
//	//��û���� ������
//	public LoanCheckVO checkdetail(LoanCheckVO vo) {
//		return ss.selectOne("loan.checkdetail",vo);
//	}
//
//	//������� ����
//	public void stateupdate(int lc_num) {
//		ss.update("loan.stateupdate",lc_num);
//	}
//	//���� ������ ���� Ȩ
//	public LoanFileVO fileuploadhome(int mem_code) {
//		return ss.selectOne("loan.fileuploadhome",mem_code);
//	}
//
//	//���� ����(���� ���� ����)
//	public void loanstart(int lc_num) {
//		ss.update("loan.loanstart", lc_num);
//	}
//	//���� ����(���� ��ȯ ���� �Է�)
//	public void loanrepaystart(LoanRepayVO vo) {
//		ss.insert("loan.loanrepay", vo);
//	}
//	//���� ��ȯ ���� ���ݰ��� ��������
//	public List<AccountVO> repayaccount(int mem_code) {
//		return ss.selectList("loan.selectaccount",mem_code);
//	}
//	//���� ��ȯ�ϱ�
//	public void repayloan(LoanRepayVO vo) {
//		ss.update("loan.repayloan",vo);
//	}  
//	//���� ��ȯ  �α�
//	public void repaylog(LoanRepayLogVO vo) {
//		ss.insert("loan.repaylog", vo);
//	}
//	public int balance(int lc_num) {
//		return ss.selectOne("loan.balance",lc_num);
//	}
//	public void loanend(int lc_num) {
//		ss.update("loan.end",lc_num);
//		
//	}
//	
//	public List<FilenameVO> filelist(){
//		return ss.selectList("loan.filename");
//	}
//	
//	public void fileup(LoanFileVO vo) {
//		ss.insert("loan.fileup",vo);
//	}
//	
//	public List<LoanFileVO> filelist(int lc_num){
//		return ss.selectList("loan.checkfiledetail",lc_num);
//	}
//	
//	public String checkstate(int lc_num) {
//		return ss.selectOne("loan.checkstate",lc_num);
//	}
//}
//>>>>>>> refs/remotes/origin/backupmaster
