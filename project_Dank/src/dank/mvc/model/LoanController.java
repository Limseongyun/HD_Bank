package dank.mvc.model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.LoanDao;
import dank.mvc.service.LoanService;
import dank.mvc.vo.FilenameVO;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCaculatorVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;
import dank.mvc.vo.LoanRepayLogVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.TransferDTO;

@Controller
public class LoanController {
	//��ȣ��
	
	@Autowired
	private LoanDao loanDao;
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private BangkingDao bangkingdao;
	
	
	//���� ��ǰ ���� ��������
	@RequestMapping(value = "/product")
	public String product(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
		return "loan/product";
	}
	
	//���� ��ǰ ������ ajax�� ��������
	@RequestMapping(value = "/productinfo")
	public ModelAndView productinfo(int lp_num) {
		ModelAndView mav = new ModelAndView("loan/server/productserver");
		LoanProductVO vo = loanDao.getProductInfo(lp_num);	
		mav.addObject("vo", vo);
		
		return mav;
	}
	//���� ��û
	@RequestMapping(value = "/application")
	public String application(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
		return "loan/application";
	}
	//���� ��û��
	@RequestMapping(value = "/applicationform")
	public String applicationform(Model model,int lp_num,HttpSession session) {
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //���� ������ �����Ѵٸ� home ���� 
			session.setAttribute("pageName", "application");
			return "login/login";
		}		
		LoanProductVO vo = loanDao.getProductInfo(lp_num);
		model.addAttribute("vo", vo);
		return "loan/applicationform";
	}
	//���� ��û
	@RequestMapping(value = "/applicationsuccess",method = RequestMethod.POST)
	public String applicationsuccess(LoanCheckVO vo,LoanApplicationVO avo) {
		loanService.addloanaplication(avo, vo);
		return "redirect:success";
	}
	//���� ���� ������
	@RequestMapping(value = "/success")
	public String success() {
		return "loan/applicationsuccess";
	}
	//��û ���� ���� ����Ʈ
	@RequestMapping(value = "/check")
	public ModelAndView check(HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/check");

		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //���� ������ �����Ѵٸ� home ���� 
			session.setAttribute("pageName", "check");
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	
	//��û ���� ������
	@RequestMapping(value = "/checkdetail")
	public ModelAndView checkdetail(int lc_num,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loan/checkdetail");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanCheckVO vo = new LoanCheckVO();
		vo.setLc_num(lc_num);
		vo.setMem_code(mem_code);
		mav.addObject("vo",loanDao.checkdetail(vo));
		return mav;
	}
	/*
	@RequestMapping(value = "/checkfile")
	public ModelAndView checkfile(int lc_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lc_num", lc_num);
		mav.setViewName("loan/checkfile");
		return mav;
	}
	*/
	@RequestMapping(value = "/checkfile")
	public ModelAndView checkfile(int lc_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lc_num", lc_num);
		List<FilenameVO> list = loanDao.filelist();
		mav.addObject("list", list);
		mav.setViewName("loan/checkfile_final");
		return mav;
	}
	@RequestMapping(value = "/checkrefile")
	public ModelAndView checkrefile(int lc_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lc_num", lc_num);
		mav.setViewName("loan/checkrefile");
		return mav;
	}
	
	
	//���� ���ε� ����Ʈ
	@RequestMapping(value = "/fileuploadhome")
	public ModelAndView fileuploadhome(HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/fileuploadhome");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //���� ������ �����Ѵٸ� home ���� 
			session.setAttribute("pageName", "fileuploadhome");
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//���� ���� ������
	@RequestMapping(value = "/checkfiledetail")
	public ModelAndView checkfiledetail(int lc_num) {
		ModelAndView mav = new ModelAndView("loan/checkfiledetail");
		LoanFileVO vo = loanDao.filedetail(lc_num);
		String[] arr = new String[20];
		mav.addObject("vo", vo);
		mav.addObject("arr", arr);
		
		return mav;
	}
	//���� ����
	@RequestMapping(value = "/loanstart")
	public  ModelAndView loanstart(int lc_num,String ac_num,HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:check");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanCheckVO v = new LoanCheckVO();
		v.setMem_code(mem_code);
		v.setLc_num(lc_num);
		LoanCheckVO check = loanDao.checkdetail(v);
		LoanRepayVO vo = new LoanRepayVO();
		vo.setLc_num(check.getLc_num());
		vo.setLr_amount(check.getLoanApplicationVO().getLa_hamount());
		vo.setLr_balance(vo.getLr_amount());
		Calendar cal = Calendar.getInstance();
		vo.setLr_repaydate(cal.get(Calendar.DAY_OF_MONTH));
		int livingterm = Integer.parseInt(check.getLoanApplicationVO().getLa_livingterm().substring(0,1));
		cal.add(Calendar.YEAR, livingterm);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day= cal.get(Calendar.DAY_OF_MONTH);
		vo.setLr_firstdate(year+"/"+month+"/"+day);
		vo.setLr_reaccount(ac_num);
		
		
		
		TransferDTO my_tr =new TransferDTO();
		my_tr.setAc_num("9001111111");
		my_tr.setHd_code("2");
		my_tr.setAt_dps_ac(ac_num);
		my_tr.setAt_set_mony(String.valueOf(vo.getLr_amount()));
		my_tr.setSp_name(check.getLoanProductVO().getLp_name());
		
		
		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(vo.getLr_reaccount());
		your_tr.setMem_code(String.valueOf(mem_code));
		your_tr.setAt_dps_ac("9001111111");
		your_tr.setAt_set_mony(String.valueOf(vo.getLr_amount()));
		your_tr.setSp_name(check.getLoanProductVO().getLp_name());
		
		

		
		
		
		if(bangkingdao.trtrAcChk("9001111111") >=1) {
			if(bangkingdao.trtrAcChk(ac_num) >=1) {
				if(Long.parseLong(bangkingdao.trbalChkadmin(my_tr)) >=Long.parseLong(String.valueOf(vo.getLr_amount()))) {
					loanService.startrepay(vo, my_tr,your_tr);
				}
			}
		}
		
		return mav;
	}
	//���� ��ȯ ��
	@RequestMapping(value = "/repaymentloan")
	public ModelAndView repayloan(HttpSession session,int lc_num) {
		ModelAndView mav = new ModelAndView("loan/repaymentloan");
		LoanCheckVO v = new LoanCheckVO();
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		v.setLc_num(lc_num);
		v.setMem_code(mem_code);
		
		LoanCheckVO vo = loanDao.checkdetail(v);
		mav.addObject("vo", vo);
		
		
		List<AccountVO> list = loanDao.repayaccount(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//���� ��ȯ
	
	@RequestMapping(value = "/loanrepay")
	public ModelAndView loanrepay(HttpSession session,String lr_balance,String ac_num,String lp_name,int lc_num,int lp_cancelfee) {
		ModelAndView mav = new ModelAndView("redirect:check");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanRepayVO vo = new LoanRepayVO();
		double balance = Double.parseDouble(lr_balance);
		double bal1 = (double)(balance/100);
		System.out.println("bal1:"+bal1);
		double bal2 = bal1*(100-lp_cancelfee);
		System.out.println("bal2"+bal2);
		int bal = (int)Math.round(bal2);
		System.out.println("bal="+bal);
		
		vo.setLc_num(lc_num);
		vo.setLr_balance(bal);		

		LoanRepayLogVO logVO = new LoanRepayLogVO();
		logVO.setLc_num(lc_num);
		logVO.setLrl_amount(bal);
		logVO.setLrl_interest(Integer.parseInt(lr_balance)-bal);
		logVO.setLrl_total(Integer.parseInt(lr_balance));
		
		
		TransferDTO my_tr =new TransferDTO();
		my_tr.setAc_num(ac_num);
		my_tr.setMem_code(String.valueOf(mem_code));
		my_tr.setAt_dps_ac("9002222222");
		my_tr.setAt_set_mony(lr_balance);
		my_tr.setSp_name(lp_name+" ��ȯ");

		
		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num("9002222222");
		your_tr.setHd_code("2");
		your_tr.setAt_dps_ac(ac_num);
		your_tr.setAt_set_mony(lr_balance);
		your_tr.setSp_name(lp_name+" ��ȯ");
		
		

	
		
		
		if(bangkingdao.trtrAcChk("9001111111") >=1) {
			if(bangkingdao.trtrAcChk(ac_num) >=1) {
				if(Long.parseLong(bangkingdao.trbalChk(my_tr)) >=Long.parseLong(lr_balance)) {
					loanService.repayloan(my_tr,your_tr,vo,logVO);
				
			}
		}
		}
		return mav;
	}
	//���� ���� ��
	@RequestMapping(value = "/repaymentstart")
	public ModelAndView repaymentstart(int lc_num,HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/repaymentstart"); 
		LoanCheckVO v = new LoanCheckVO();
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		v.setLc_num(lc_num);
		v.setMem_code(mem_code);
		
		LoanCheckVO vo = loanDao.checkdetail(v);
		mav.addObject("vo", vo);
		
		
		List<AccountVO> list = loanDao.repayaccount(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//���� ���� ���
	@RequestMapping(value = "/caculator", method = RequestMethod.POST)
	public ModelAndView caculator(LoanCaculatorVO vo) {
		ModelAndView mav = new ModelAndView("loan/server/caculatorserver");
		List<LoanCaculatorVO> list = new ArrayList<LoanCaculatorVO>();
		
		int m = vo.getM();
		int g = vo.getG();
		float r = vo.getR()/100;
		int n = vo.getN();
		if(vo.getTerm()==1) {
			n *=12;
		}
		if(vo.getTerm2()==1) {
			g*=12;
		}
		int totalterm = n+g;
		
		if(vo.getType()==1) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					v.setRepayM(0);
					v.setRepayR((int)Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayM()+v.getRepayR());
				}else {
					v.setRepayM(m/n);
					v.setRepayR((int) Math.ceil((m-((i-g)*m/n))*r/n));
					v.setRepayMR(v.getRepayM()+v.getRepayR());
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
					}
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				
				list.add(v);
			
			}
			
		}else if(vo.getType()==2) {
			
			for(int i =0;i<totalterm;i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					v.setRepayR((int) Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayR());
					v.setRepayM(0);
				}else {
					if(i==0) {
						v.setRepayR((int) Math.ceil((m*(r/12))));
					}else {	
						v.setRepayR((int) Math.ceil(list.get(list.size()-1).getBalance()*(r/12)));
					}	
					
					v.setRepayMR((int) (((m*r/12)*(Math.pow((1+r/12), n)))/((Math.pow((1+r/12), n))-1)));
					v.setRepayM(v.getRepayMR()-v.getRepayR());
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
					}
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				list.add(v);
			}
		}else if(vo.getType()==3) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				v.setRepayR((int) (m*r/12));
				if(i!=totalterm-1) {
					v.setRepayM(0);
					v.setRepayMR(v.getRepayR());
				}else {
					v.setRepayM(m);
					v.setRepayMR(v.getRepayR()+v.getRepayM());
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				
				list.add(v);
			}
		}
		mav.addObject("list", list);
		return mav;
	}
	
	
	
	
	//���� ��ȯ ����Ʈ
	@RequestMapping(value = "/repayment")
	public ModelAndView repayment(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("loan/repayment");

		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //���� ������ �����Ѵٸ� home ���� 
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;		
	}
	//���� ���� �̵�
	@RequestMapping(value = "/caculator")
	public String caculator() {
		return "loan/caculator";
	}
	// ���⼭�� �ٿ�ε�
	 @RequestMapping("/fileDown.do")
	   public String fileDown(HttpServletRequest req , ModelMap modelMap) throws Exception {
	     String fileName = req.getParameter("fileName");
	     String fileDir =  req.getParameter("fileDir");
	      
	     modelMap.put("fileName", fileName);
	     modelMap.put("fileDir", fileDir);
	     return "/loan/server/filedown";
	   }
	 //���� ���� ���
	 @RequestMapping(value = "/fileupload",method =  RequestMethod.POST)
		public ModelAndView fileupload(LoanFileVO vo,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView("redirect:check");//view�� �̸��� �������� ���ڰ����� ����
			HttpSession session = request.getSession();
			String r_path = session.getServletContext().getRealPath("/");
			String img_path ="resources\\upload\\";
			
			 try {
				 File ff = null; 
				 ff = new File(r_path+img_path+vo.getLc_num());
				 if(!ff.exists()) {
					 ff.mkdirs();
				 }
				 
				 int file1 = vo.getMfile1().getOriginalFilename().lastIndexOf( "." );;
				 if (file1!=-1) {
				 StringBuffer path1 = new StringBuffer();
				 path1.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile1().getOriginalFilename());
				 ff = new File(path1.toString());
				 vo.getMfile1().transferTo(ff);
				 vo.setFile1(vo.getMfile1().getOriginalFilename());
			}
				 int file2 = vo.getMfile2().getOriginalFilename().lastIndexOf( "." );;
				 if (file2!=-1) {
				 StringBuffer path2 = new StringBuffer();
				 path2.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile2().getOriginalFilename());
				 ff = new File(path2.toString());
				 vo.getMfile2().transferTo(ff);
				 vo.setFile2(vo.getMfile2().getOriginalFilename()); 
			}

				 int file3 = vo.getMfile3().getOriginalFilename().lastIndexOf( "." );;
				 if (file3!=-1) {
				 StringBuffer path3 = new StringBuffer();
				 path3.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile3().getOriginalFilename());
				 ff = new File(path3.toString());
				 vo.getMfile3().transferTo(ff);
				 vo.setFile3(vo.getMfile3().getOriginalFilename());
			}
				 int file4 = vo.getMfile4().getOriginalFilename().lastIndexOf( "." );;
				 if (file4!=-1) {
				 StringBuffer path4 = new StringBuffer();
				 path4.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile4().getOriginalFilename());
				 ff = new File(path4.toString());
				 vo.getMfile4().transferTo(ff);
				 vo.setFile4(vo.getMfile4().getOriginalFilename());
			}
				 int file5 = vo.getMfile5().getOriginalFilename().lastIndexOf( "." );;
				 if (file5!=-1) {
				 StringBuffer path5 = new StringBuffer();
				 path5.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile5().getOriginalFilename());
				 ff = new File(path5.toString());
				 vo.getMfile5().transferTo(ff);
				 vo.setFile5(vo.getMfile5().getOriginalFilename());
			}
			
				 int file6 = vo.getMfile6().getOriginalFilename().lastIndexOf( "." );;
				 if (file6!=-1) {
				 StringBuffer path6 = new StringBuffer();
				 path6.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile6().getOriginalFilename());
				 ff = new File(path6.toString());
				 vo.getMfile6().transferTo(ff);
				 vo.setFile6(vo.getMfile6().getOriginalFilename());
			}
				 int file7 = vo.getMfile7().getOriginalFilename().lastIndexOf( "." );;
				 if (file7!=-1) {
				 StringBuffer path7 = new StringBuffer();
				 path7.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile7().getOriginalFilename());
				 ff = new File(path7.toString());
				 vo.getMfile7().transferTo(ff);
				 vo.setFile7(vo.getMfile7().getOriginalFilename());
			}
				 int file8 = vo.getMfile8().getOriginalFilename().lastIndexOf( "." );;
				 if (file8!=-1) {
				 StringBuffer path8 = new StringBuffer();
				 path8.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile8().getOriginalFilename());
				 ff = new File(path8.toString());
				 vo.getMfile8().transferTo(ff);
				 vo.setFile8(vo.getMfile2().getOriginalFilename());
			}
				 int file9 = vo.getMfile9().getOriginalFilename().lastIndexOf( "." );;
				 if (file9!=-1) {
				 StringBuffer path9 = new StringBuffer();
				 path9.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile9().getOriginalFilename());
				 ff = new File(path9.toString());
				 vo.getMfile9().transferTo(ff);
				 vo.setFile9(vo.getMfile9().getOriginalFilename());
			}
				 int file10 = vo.getMfile10().getOriginalFilename().lastIndexOf( "." );;
				 if (file10!=-1) {
				 StringBuffer path10 = new StringBuffer();
				 path10.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile10().getOriginalFilename());
				 ff = new File(path10.toString());
				 vo.getMfile10().transferTo(ff);
				 vo.setFile10(vo.getMfile10().getOriginalFilename());
			}
				 int file11 = vo.getMfile11().getOriginalFilename().lastIndexOf( "." );;
				 if (file11!=-1) {
				 StringBuffer path11 = new StringBuffer();
				 path11.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile11().getOriginalFilename());
				 ff = new File(path11.toString());
				 vo.getMfile11().transferTo(ff);
				 vo.setFile11(vo.getMfile11().getOriginalFilename());
			}
				 int file12 = vo.getMfile12().getOriginalFilename().lastIndexOf( "." );;
				 if (file12!=-1) {
				 StringBuffer path12 = new StringBuffer();
				 path12.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile12().getOriginalFilename());
				 ff = new File(path12.toString());
				 vo.getMfile12().transferTo(ff);
				 vo.setFile12(vo.getMfile12().getOriginalFilename());
			}
				 int file13 = vo.getMfile13().getOriginalFilename().lastIndexOf( "." );;
				 if (file13!=-1) {
				 StringBuffer path13 = new StringBuffer();
				 path13.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile13().getOriginalFilename());
				 ff = new File(path13.toString());
				 vo.getMfile13().transferTo(ff);
				 vo.setFile13(vo.getMfile13().getOriginalFilename());
			}
				 int file14 = vo.getMfile14().getOriginalFilename().lastIndexOf( "." );;
				 if (file14!=-1) {
				 StringBuffer path14 = new StringBuffer();
				 path14.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile14().getOriginalFilename());
				 ff = new File(path14.toString());
				 vo.getMfile14().transferTo(ff);
				 vo.setFile14(vo.getMfile14().getOriginalFilename()); 

			}
				 int file15 = vo.getMfile15().getOriginalFilename().lastIndexOf( "." );;
				 if (file15!=-1) {
				 StringBuffer path15 = new StringBuffer();
				 path15.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile15().getOriginalFilename());
				 ff = new File(path15.toString());
				 vo.getMfile15().transferTo(ff);
				 vo.setFile15(vo.getMfile15().getOriginalFilename());
			}
				 int file16 = vo.getMfile16().getOriginalFilename().lastIndexOf( "." );;
				 if (file16!=-1) {
				 StringBuffer path16 = new StringBuffer();
				 path16.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile16().getOriginalFilename());
				 ff = new File(path16.toString());
				 vo.getMfile16().transferTo(ff);
				 vo.setFile16(vo.getMfile16().getOriginalFilename());
			}
				 int file17 = vo.getMfile17().getOriginalFilename().lastIndexOf( "." );;
				 if (file17!=-1) {
				 StringBuffer path17 = new StringBuffer();
				 path17.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile17().getOriginalFilename());
				 ff = new File(path17.toString());
				 vo.getMfile17().transferTo(ff);
				 vo.setFile17(vo.getMfile17().getOriginalFilename()); 
			}
				 int file18 = vo.getMfile18().getOriginalFilename().lastIndexOf( "." );;
				 if (file18!=-1) {
				 StringBuffer path18 = new StringBuffer();
				 path18.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile18().getOriginalFilename());
				 ff = new File(path18.toString());
				 vo.getMfile18().transferTo(ff);
				 vo.setFile18(vo.getMfile18().getOriginalFilename());
			}
				 int file19 = vo.getMfile19().getOriginalFilename().lastIndexOf( "." );;
				 if (file19!=-1) {
				 StringBuffer path19 = new StringBuffer();
				 path19.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile19().getOriginalFilename());
				 ff = new File(path19.toString());
				 vo.getMfile19().transferTo(ff);
				 vo.setFile19(vo.getMfile19().getOriginalFilename());
			}
				 int file20 = vo.getMfile20().getOriginalFilename().lastIndexOf( "." );;
				 if (file20!=-1) {
				 StringBuffer path20 = new StringBuffer();
				 path20.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile20().getOriginalFilename());
				 ff = new File(path20.toString());
				 vo.getMfile20().transferTo(ff);
				 vo.setFile20(vo.getMfile20().getOriginalFilename());
			}
			
			//VO�� �̹��� �̸��� ����
		
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			loanService.fileupload(vo);
			return mav;
		}
	 //���� ���� ���� ����
	 @RequestMapping(value = "/refileupload",method =  RequestMethod.POST)
		public ModelAndView refileupload(LoanFileVO vo,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView("redirect:check");//view�� �̸��� �������� ���ڰ����� ����
			HttpSession session = request.getSession();
			String r_path = session.getServletContext().getRealPath("/");
			String img_path ="resources\\upload\\";
			 try {
				 File ff = null; 
				 ff = new File(r_path+img_path+vo.getLc_num());
				 if(!ff.exists()) {
					 ff.mkdirs();
				 }
				 
				 int file1 = vo.getMfile1().getOriginalFilename().lastIndexOf( "." );;
				 if (file1!=-1) {
				 StringBuffer path1 = new StringBuffer();
				 path1.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile1().getOriginalFilename());
				 ff = new File(path1.toString());
				 vo.getMfile1().transferTo(ff);
				 vo.setFile1(vo.getMfile1().getOriginalFilename());
			}
				 int file2 = vo.getMfile2().getOriginalFilename().lastIndexOf( "." );;
				 if (file2!=-1) {
				 StringBuffer path2 = new StringBuffer();
				 path2.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile2().getOriginalFilename());
				 ff = new File(path2.toString());
				 vo.getMfile2().transferTo(ff);
				 vo.setFile2(vo.getMfile2().getOriginalFilename()); 
			}

				 int file3 = vo.getMfile3().getOriginalFilename().lastIndexOf( "." );;
				 if (file3!=-1) {
				 StringBuffer path3 = new StringBuffer();
				 path3.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile3().getOriginalFilename());
				 ff = new File(path3.toString());
				 vo.getMfile3().transferTo(ff);
				 vo.setFile3(vo.getMfile3().getOriginalFilename());
			}
				 int file4 = vo.getMfile4().getOriginalFilename().lastIndexOf( "." );;
				 if (file4!=-1) {
				 StringBuffer path4 = new StringBuffer();
				 path4.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile4().getOriginalFilename());
				 ff = new File(path4.toString());
				 vo.getMfile4().transferTo(ff);
				 vo.setFile4(vo.getMfile4().getOriginalFilename());
			}
				 int file5 = vo.getMfile5().getOriginalFilename().lastIndexOf( "." );;
				 if (file5!=-1) {
				 StringBuffer path5 = new StringBuffer();
				 path5.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile5().getOriginalFilename());
				 ff = new File(path5.toString());
				 vo.getMfile5().transferTo(ff);
				 vo.setFile5(vo.getMfile5().getOriginalFilename());
			}
			
				 int file6 = vo.getMfile6().getOriginalFilename().lastIndexOf( "." );;
				 if (file6!=-1) {
				 StringBuffer path6 = new StringBuffer();
				 path6.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile6().getOriginalFilename());
				 ff = new File(path6.toString());
				 vo.getMfile6().transferTo(ff);
				 vo.setFile6(vo.getMfile6().getOriginalFilename());
			}
				 int file7 = vo.getMfile7().getOriginalFilename().lastIndexOf( "." );;
				 if (file7!=-1) {
				 StringBuffer path7 = new StringBuffer();
				 path7.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile7().getOriginalFilename());
				 ff = new File(path7.toString());
				 vo.getMfile7().transferTo(ff);
				 vo.setFile7(vo.getMfile7().getOriginalFilename());
			}
				 int file8 = vo.getMfile8().getOriginalFilename().lastIndexOf( "." );;
				 if (file8!=-1) {
				 StringBuffer path8 = new StringBuffer();
				 path8.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile8().getOriginalFilename());
				 ff = new File(path8.toString());
				 vo.getMfile8().transferTo(ff);
				 vo.setFile8(vo.getMfile2().getOriginalFilename());
			}
				 int file9 = vo.getMfile9().getOriginalFilename().lastIndexOf( "." );;
				 if (file9!=-1) {
				 StringBuffer path9 = new StringBuffer();
				 path9.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile9().getOriginalFilename());
				 ff = new File(path9.toString());
				 vo.getMfile9().transferTo(ff);
				 vo.setFile9(vo.getMfile9().getOriginalFilename());
			}
				 int file10 = vo.getMfile10().getOriginalFilename().lastIndexOf( "." );;
				 if (file10!=-1) {
				 StringBuffer path10 = new StringBuffer();
				 path10.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile10().getOriginalFilename());
				 ff = new File(path10.toString());
				 vo.getMfile10().transferTo(ff);
				 vo.setFile10(vo.getMfile10().getOriginalFilename());
			}
				 int file11 = vo.getMfile11().getOriginalFilename().lastIndexOf( "." );;
				 if (file11!=-1) {
				 StringBuffer path11 = new StringBuffer();
				 path11.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile11().getOriginalFilename());
				 ff = new File(path11.toString());
				 vo.getMfile11().transferTo(ff);
				 vo.setFile11(vo.getMfile11().getOriginalFilename());
			}
				 int file12 = vo.getMfile12().getOriginalFilename().lastIndexOf( "." );;
				 if (file12!=-1) {
				 StringBuffer path12 = new StringBuffer();
				 path12.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile12().getOriginalFilename());
				 ff = new File(path12.toString());
				 vo.getMfile12().transferTo(ff);
				 vo.setFile12(vo.getMfile12().getOriginalFilename());
			}
				 int file13 = vo.getMfile13().getOriginalFilename().lastIndexOf( "." );;
				 if (file13!=-1) {
				 StringBuffer path13 = new StringBuffer();
				 path13.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile13().getOriginalFilename());
				 ff = new File(path13.toString());
				 vo.getMfile13().transferTo(ff);
				 vo.setFile13(vo.getMfile13().getOriginalFilename());
			}
				 int file14 = vo.getMfile14().getOriginalFilename().lastIndexOf( "." );;
				 if (file14!=-1) {
				 StringBuffer path14 = new StringBuffer();
				 path14.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile14().getOriginalFilename());
				 ff = new File(path14.toString());
				 vo.getMfile14().transferTo(ff);
				 vo.setFile14(vo.getMfile14().getOriginalFilename()); 

			}
				 int file15 = vo.getMfile15().getOriginalFilename().lastIndexOf( "." );;
				 if (file15!=-1) {
				 StringBuffer path15 = new StringBuffer();
				 path15.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile15().getOriginalFilename());
				 ff = new File(path15.toString());
				 vo.getMfile15().transferTo(ff);
				 vo.setFile15(vo.getMfile15().getOriginalFilename());
			}
				 int file16 = vo.getMfile16().getOriginalFilename().lastIndexOf( "." );;
				 if (file16!=-1) {
				 StringBuffer path16 = new StringBuffer();
				 path16.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile16().getOriginalFilename());
				 ff = new File(path16.toString());
				 vo.getMfile16().transferTo(ff);
				 vo.setFile16(vo.getMfile16().getOriginalFilename());
			}
				 int file17 = vo.getMfile17().getOriginalFilename().lastIndexOf( "." );;
				 if (file17!=-1) {
				 StringBuffer path17 = new StringBuffer();
				 path17.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile17().getOriginalFilename());
				 ff = new File(path17.toString());
				 vo.getMfile17().transferTo(ff);
				 vo.setFile17(vo.getMfile17().getOriginalFilename()); 
			}
				 int file18 = vo.getMfile18().getOriginalFilename().lastIndexOf( "." );;
				 if (file18!=-1) {
				 StringBuffer path18 = new StringBuffer();
				 path18.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile18().getOriginalFilename());
				 ff = new File(path18.toString());
				 vo.getMfile18().transferTo(ff);
				 vo.setFile18(vo.getMfile18().getOriginalFilename());
			}
				 int file19 = vo.getMfile19().getOriginalFilename().lastIndexOf( "." );;
				 if (file19!=-1) {
				 StringBuffer path19 = new StringBuffer();
				 path19.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile19().getOriginalFilename());
				 ff = new File(path19.toString());
				 vo.getMfile19().transferTo(ff);
				 vo.setFile19(vo.getMfile19().getOriginalFilename());
			}
				 int file20 = vo.getMfile20().getOriginalFilename().lastIndexOf( "." );;
				 if (file20!=-1) {
				 StringBuffer path20 = new StringBuffer();
				 path20.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(vo.getMfile20().getOriginalFilename());
				 ff = new File(path20.toString());
				 vo.getMfile20().transferTo(ff);
				 vo.setFile20(vo.getMfile20().getOriginalFilename());
			}
			
			//VO�� �̹��� �̸��� ����
		
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			loanDao.refileupload(vo);
			return mav;
		}

}