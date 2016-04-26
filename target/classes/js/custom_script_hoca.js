$(document).ready(function(){
	
	
	
	 $('#ayarlarForm').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            username: {
	                validators: { 
	                	notEmpty: {
	                        message: 'Kullanici ad gereklidir ve bos birakilamaz'
	                    },   
	                	
	                }
	            },
	            ad: {
	                validators: { 
	                	notEmpty: {
	                        message: 'Isim gereklidir ve bos birakilamaz'
	                    },   
	                	
	                }
	            },
	            soyad: {
	                validators: {
	                	notEmpty: {
	                        message: 'Soyad gereklidir ve bos birakilamaz'
	                    },   
	                }
	            },
	            password: {
	                validators: {
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: 'Sifre en az 6 en fazla 30 karakterden olusmalidir'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_]+$/,
	                        message: 'Sifrede harfler,sayilar ve alt cizgi kullanabilirsiniz'
	                    },
	                    identical: {
	                        field: 'repeatpassword',
	                        message: 'Sifreler eslesmiyor'
	                    }
	                }
	            },
	            repeatpassword: {
	                validators: {
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: 'Sifre en az 6 en fazla 30 karakterden olusmalidir'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_]+$/,
	                        message: 'Sifrede harfler,sayilar ve alt cizgi kullanabilirsiniz'
	                    },
	                    identical: {
	                        field: 'password',
	                        message: 'Sifreler eslesmiyor'
	                    }
	                }
	            }
	        }
	      
	    });
	
});