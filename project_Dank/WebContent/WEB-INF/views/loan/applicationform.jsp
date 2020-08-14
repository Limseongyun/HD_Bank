<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
label{
padding-top: 10px;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

</style>
			<div class="content">
			<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">����</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="application" class="btn btn-white btn-sm btn-border mr-1">�����û</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">���� ������</a>
								<a href="qna" class="btn btn-secondary btn-round">������</a>
							</div>
						</div>
					</div>
				</div>
				<!--���� ��û   -->
		<form action="applicationsuccess" method="post" class="form-horizontal">
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
												<h1>���� ��û</h1>
												<hr>
												<h3>��û�� ����</h3>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">�̸�</label>
													<div class="col-10">
   														<input type="text" class="form-control"  id="name" readonly="readonly" value="${member.mem_name }">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">�̸���</label>
													<div class="col-10">
   														<input type="text" class="form-control"  id="name" readonly="readonly" value="${member.mem_email }">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">�������</label>
													<div class="col-10">
   														<input type="text" class="form-control"  id="name" readonly="readonly" value="${member.mem_birth }">
   													</div>
												</div>
												
   														<input type="hidden" class="form-control"  id="mem_code" name="mem_code"  value="${member.mem_code }">
   												
												<hr>
												<h3>���� ����</h3>
												<div class="form-group row">
													<label for="loanname" class="col-2 control-label" >�����</label>
													<div class="col-10">
	   													<input type="text" class="form-control" name="lp_name" id="lp_name" readonly="readonly" value="${vo.lp_name }">
														<input type="hidden" name="lp_num" id="lp_num" value="${vo.lp_num }">
													</div>
												</div>
												
												<div class="form-group row">
													<label for="interestrate" class="col-2">��������</label>
													<div class="col-10">
   														<input type="text" class="form-control" id="interestrate" readonly="readonly" value="${vo.lp_interestrate }%">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">�ִ� ���� ����  �ݾ�</label>
													<div class="col-10">
   														<input type="text" class="form-control" readonly="readonly" value="${vo.lp_maximum }��">
   													</div>
   													
												</div>
												
												<div class="form-group row">
												<label for="amount" class="col-2">���� ��� �ݾ�</label>
												<div class="col-6">
												<input type="hidden" id="maximum" value="${vo.lp_maximum }">
												<input type="number" class="form-control" name="la_hamount" id="la_hamount"  placeholder="����ݾ�" value="0">
												</div>
												<div class="col-4">
   														<p id="target"></p>
   													</div>
											</div>
												
												<div class="form-group row">
													<label for="interestrate" class="col-2">���������</label>
													<div class="col-10">
   														<input type="date" name="la_startdate" id="la_startdate" class="form-control">
   													</div>
												</div>
												
												
												
												
												<div class="form-group row">
												<label for="period" class="col-2">��ġ�Ⱓ</label>
												<div class="col-4">
												<select class="form-control" id="la_livingterm" name="la_livingterm">
													<option value="0">����</option>
													<option>1��</option>
													<option>2��</option>
													<option>3��</option>
												</select>
												</div>
												<label for="period" class="col-2">��ȯ�Ⱓ</label>
												<div class="col-4">
												<select class="form-control" id="la_repayterm" name="la_repayterm">
													<option>1��</option>
													<option>2��</option>
													<option>3��</option>
													<option>5��</option>
													<option>10��</option>
												</select>
												</div>
											</div>
												
												<div class="form-group row">
												<label for="period" class="col-2">��ȯ���</label>
												<div class="col-10">
												<select class="form-control" id="lr_type" name="lr_type">
													<option>�����ݱյ��ȯ</option>
													<option>���ݱյ��ȯ</option>
													<option>�����Ͻû�ȯ</option>
												</select>
												</div>
											</div>
											
											
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
			
					
			<p class="text-center"><button type="submit" class="btn btn-info">���� ��û</button></p>
		</form>
			</div>
		
			


			
			<script>
			$("input").keydown(function () {
			    // Save old value.
			    if (!$(this).val() || (parseInt($(this).val()) <= $('#maximum').val()  && parseInt($(this).val()) >= 0))
			    $(this).data("old", $(this).val());
			  });
			  $("input").keyup(function () {
			    // Check correct, else revert back to old value.
			    if (!$(this).val() || (parseInt($(this).val()) <= $('#maximum').val() && parseInt($(this).val()) >= 0)){
			    	
			    }else if(parseInt($(this).val()) < 0){
			    	alert('���������� ������ �� �� �����ϴ�.')
			    	$(this).val(0);
			    }else{
				  	alert('���� ���� �ִ� �ݾ��� �ʰ��ؼ� �Է��ϼ̽��ϴ�.')			    	
			    	$(this).val($(this).data("old"));
			    }
			   

			  });
			  
			  $('#la_hamount').change(function() {
				  var amount = parseInt($('#la_hamount').val());
				  var result = '';
				  if(amount<10000){
					  result = amount+'��';
					  $('#target').html(result); 
				  }else if(amount<100000000){
					 console.log(result/10000)
					  result = Math.floor(amount/10000) + '��' + (amount%10000) + '��';
					  $('#target').html(result);
				  }else if(amount<1000000000000){
					  result = Math.floor(amount/100000000) + '��' + Math.floor((amount%100000000)/10000) + '��' + (amount%10000) + '��';
					  $('#target').html(result); 
				  }
			  })
			  
			  $('#la_hamount').keyup(function() {
				  var amount = parseInt($('#la_hamount').val());
				  var result = '';
				  if(amount<10000){
					  result = amount+'��';
					  $('#target').html(result); 
				  }else if(amount<100000000){
					 console.log(result/10000)
					  result = Math.floor(amount/10000) + '��' + (amount%10000) + '��';
					  $('#target').html(result);
				  }else if(amount<1000000000000){
					  result = Math.floor(amount/100000000) + '��' + Math.floor((amount%100000000)/10000) + '��' + (amount%10000) + '��'
					  $('#target').html(result); 
				  }
			  })
			  
			  
				var date = new Date().toISOString().slice(0, 10);
				var dateSplit = date.split("-");
				var sysdate = new Date(dateSplit[0]+'/'+dateSplit[1]+'/'+dateSplit[2]);
				var startdate = new Date(dateSplit[0]+'/'+dateSplit[1]+'/'+dateSplit[2]);
				startdate.setDate(sysdate.getDate()+8);
				var defaultdate = startdate.toISOString().slice(0,10);
				$('#la_startdate').attr("value", defaultdate);
			
				$('#la_startdate').change(function() {
					var startdate = $('#la_startdate').val();
					var startdateSplit=startdate.split("-");
					var startDate = new Date(startdateSplit[0]+'/'+startdateSplit[1]+'/'+startdateSplit[2]);
				if(startDate<sysdate){
					alert("����������� ���� ������ �� �����ϴ�.")
					$(this).val(date);
					$(this).attr('value',date)
				}	
			})
			
				$('form').on('focus', 'input[type=number]', function (e) {
  $(this).on('wheel.disableScroll', function (e) {
    e.preventDefault()
  })
})
$('form').on('blur', 'input[type=number]', function (e) {
  $(this).off('wheel.disableScroll')
})
	</script>


