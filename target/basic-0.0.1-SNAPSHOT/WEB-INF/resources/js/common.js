$(function(){
	
	// 상단 메뉴
	$('#btnMenu').on('mouseenter', function(){
		$('#headMenu').slideDown(200);
	});
	
	$('#headMenu').on('mouseleave', function(){
		$('#headMenu').slideUp(200);
	});

	// 로그인
	$('#btnLogin').on('click',function(){
	  $('#Login').fadeIn();
	});

	// 로그인 버튼
	$('#btn_login').on('click', function () {
		$.ajax({
			url: "/user/login",
			type: 'post',
			data: {
				userId: $("#userId"),
				userPass: $("#userPass"),
			},
			success: function (data) {
				alert("전송성공")
			},
			error: function () {
				alert("error");
			}
		});
	})

	
	$('#btnClose').on('click',function(){
	  $('#Login').fadeOut();
	});


	// 회원가입
	$('#btnRegister').on('click',function(){
	    $('#Register').fadeIn();
  });	
	
	$('#btnClose').on('click',function(){
	  $('#Register').fadeOut();
	});




	// 회원정보 수정
	$('#btnUserUpdate').on('click',function(){
		var pass = $('#userPass2').val()
		var passCheck =$('#userPassCheck').val()
		console.log(pass)
		console.log(passCheck)
		if (pass != passCheck){
			alert("비밀번호가 일치하지 않습니다.")
		}else{
			var userInfoForm = $('#form-userUpdate').serialize()
			console.log(userInfoForm)
			$.ajax({
				url: "/user/userupdate",
				type: 'post',
				data: userInfoForm,
				success: function (data) {
					alert("전송성공")
				},
				error: function () {
					alert("error");
				}
			});
			location.replace("/")
		}

	});















	// $('#btnDelete').on('click',function (){
	// 	$('bookDetail').fadeIn();
	// });

	// $('#btnDetail').on('click',function(){
	// 	alert("")
	// 	$('#detailmodal').fadeIn();
	// });


	// //책 상세보기 모달
	// $('#detailbtn').on('click', function (){
	// 	$('#bookDetail').fadeIn();
	// })
	//
	// //책 상세보기 모달 닫기
	// $('#modalClose').on('click', function (){
	// 	$('#bookDetail').hide()
	// })


	//이미지 슬라이드(좌우)
	var currentIndex = 0;
	
	setInterval(function(){
    if(currentIndex < 2){
        currentIndex++;
    } else {
        currentIndex = 0;
    }
    var slidePosition = currentIndex * (-100)+"%";
  	$(".slide-content").animate({ left:slidePosition },600);
	},6000);





























	// 게시판 검색
	/*$('#btnSearch').on('click', function(e){
		e.preventDefault();
		var url = "/board/list";
		url = url + "?searchSeclect=" + $('#searchSeclect').val();
		url = url + "&keyword=" + $('#keyword').val();
		location.href = url;
		console.log(url);
	});*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*$.extend( $.validator.messages, {
		required: "필수 항목입니다.",
		remote: "항목을 수정하세요.",
		email: "유효하지 않은 E-Mail주소입니다.",
		url: "유효하지 않은 URL입니다.",
		date: "올바른 날짜를 입력하세요.",
		dateISO: "올바른 날짜(ISO)를 입력하세요.",
		number: "유효한 숫자가 아닙니다.",
		digits: "숫자만 입력 가능합니다.",
		creditcard: "신용카드 번호가 바르지 않습니다.",
		equalTo: "같은 값을 다시 입력하세요.",
		extension: "올바른 확장자가 아닙니다.",
		maxlength: $.validator.format( "{0}자를 넘을 수 없습니다. " ),
		minlength: $.validator.format( "{0}자 이상 입력하세요." ),
		rangelength: $.validator.format( "문자 길이가 {0} 에서 {1} 사이의 값을 입력하세요." ),
		range: $.validator.format( "{0} 에서 {1} 사이의 값을 입력하세요." ),
		max: $.validator.format( "{0} 이하의 값을 입력하세요." ),
		min: $.validator.format( "{0} 이상의 값을 입력하세요." ),
	} );*/
	
	/*$('WriteForm').validate({
		// 체크할 항목 룰 설정
		rules:{
			userID : {
        required : "true",
      },
      postTitle : {
        required : "true",
        maxlength : 300
      },
      postContent : {
        required : "true",
        maxlength : 4000
      },
      commCont : {
        required : "true",
        minlength : 1,
        maxlength : 1000
      },
      req_book :{
        required : "true",
        maxlength : 200
      },
      req_cont :{
        required : "true",
        minlength : 1,
        maxlength : 400
      }
		},  
		messages:{
			userID : {
        required : "아이디를 입력하세요."
      },
       postTitle : {
        required : "제목을 입력하세요.",
        maxlength : "최대 300자까지 입력하세요."
      },
      postContent : {
        required : "내용을 입력하세요.",
        maxlength : "최대 4000자까지 입력하세요."
      },
      commCont : {
        required : "댓글을 작성하세요.",
        minlength : "최소 1자 이상 입력하세요.",
        maxlength : "최대 1000자까지 입력하세요."
      },
      req_book :{
        required : "책 이름을 입력하세요.",
        maxlength : "최대 200자까지 입력하세요."
      },
      req_cont :{
        required : "내용을 입력하세요.",
        minlength : "최소 1자 이상 입력하세요.",
        maxlength : "최대 400자까지 입력하세요."
      }
		}
	});

	$('LoginForm').validate({
		// 체크할 항목 룰 설정
		rules:{
			userID : {
        required : "true",
        equalTo : userID
      },
     	userPass : {
        required : "true",
        minlength : 4,
        maxlength : 20,
        equalTo : userPass
      },
		},  
		messages:{
			userID : {
        required : "아이디를 입력하세요.",
        equalTo : "아이디를 잘못 입력하였습니다."
      },
     	userPass : {
        required : "비밀번호를 입력하세요.",
        equalTo : "비밀번호가 일치하지 않습니다."
      },
		}
	});
	
	$('RegisterForm').validate({
		// 체크할 항목 룰 설정
		rules:{
			userID : {
        required : "true",
        minlength : 5,
        maxlength : 20,
        equalTo : userID
      },
     	userPass : {
        required : "true",
        minlength : 4,
        maxlength : 20,
        equalTo : userPass
      },
      userEmail : {
        required : "true",
        maxlength : 40,
        email : true
      },
      userPhone : {
        required : "true",
        maxlength : 11
      }
		},  
		messages:{
			userID : {
        required : "아이디를 입력하세요.",
        minlength : "최소 5자부터 입력하세요.",
        maxlength : "최대 20자까지 입력하세요.",
        equalTo : "아이디를 잘못 입력하였습니다."
      },
     	userPass : {
        required : "비밀번호를 입력하세요.",
        minlength : "최소 4자부터 입력하세요.",
        maxlength : "최대 20자까지 입력하세요.",
        equalTo : "비밀번호가 일치하지 않습니다."
      },
      userEmail : {
        required : "이메일을 입력하세요.",
        maxlength : "최대 40자까지 입력하세요.",
        email : "메일규칙에 어긋납니다"
      },
      userPhone : {
        required : "연락처를 입력하세요. ex) 000-0000-0000",
        maxlength : "최대 11자까지 입력하세요."
      }
		}
	});

	$('SubscrForm').validate({
		// 체크할 항목 룰 설정
		rules:{
			cardNum :{
        required : "true",
        maxlength : 16
      },
      cardPw :{
        required : "true",
        maxlength : 4
      }
		},  
		messages:{
			cardNum :{
        required : "카드번호를 입력하세요. 번호만 입력하세요.",
        maxlength : "최대 16자리 입력하세요. 0000-0000-0000"
      },
      cardPw :{
        required : "카드 비밀번호를 입력하세요.",
        maxlength : "비밀번호 4자리 입력하세요.",
      }
		}
	}); */


















});