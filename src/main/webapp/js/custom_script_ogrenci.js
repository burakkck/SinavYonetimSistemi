$(document).ready(function(){

	$(".bolum-select").selectpicker();
	$(".fakulte-select").selectpicker();
//	$(".sinif-select").selectpicker();

$('.table-sort').click(function (e) {
	    e.preventDefault();

	    //get the footable sort object
	    var footableSort = $('table').data('footable-sort');

	    //get the index we are wanting to sort by
	    var index = $(this).data('index');

	    //get the sort order
	    var ascending = $(this).data('ascending');

	    footableSort.doSort(index, ascending);
	});

$('#fakulte').on("change",function(){
	var fakulteNo = $(this).val(); 
	$.ajax({
		url : "getbolum",
		type: "post",
		dataType : "json",
		data : {"fakulteNo" : fakulteNo},
		success : function(data){
			$('#bolum-select option').remove();
			$('.bolum-select').selectpicker('refresh');
			$.each(data.bolum,function(i,item){
				$('#bolum-select').append($('<option>', {value:item.id, text:item.ad}));
			});
			$('.bolum-select').prop('disabled',false);
			$('.bolum-select').selectpicker('refresh');
		}
	});
});

$('#email').change(function (){
	var email = $(this).val();
		$(".status").html("<img src='image/loading.gif'><font color=gray> kontrol ediliyor...</font>");
	$.ajax({
		url : "emailcontrol",
		type : "post",
//		dataType : "json",
		data : {"email" : email},
		success : function(msg){
//			  $(".status").ajaxComplete(function(event, request){
				  if(msg == 1){
					  $(".status").html("<font color=green><b></b>Uygundur</font>");
					  $("#kayit").removeAttr("disabled");
				  }else{
					  $(".status").html("<font color=red><b></b>Bu e-posta adresi daha önce kullanılmış</font>");
					  $("#kayit").attr("disabled",true);
				  }
//                  $(".status").html(msg);

//              });
		}
	});
});

$('#ogrencino').change(function (){
	var ogrencino = $(this).val();
		$(".ogrno").html("<img src='image/loading.gif'><font color=gray> kontrol ediliyor...</font>");
	$.ajax({
		url : "ogrencinokontrol",
		type : "post",
//		dataType : "json",
		data : {"ogrencino" : ogrencino},
		success : function(msg){
//			  $(".status").ajaxComplete(function(event, request){
				  if(msg == 1){
					  $(".ogrno").html("<font color=green><b></b>Uygundur</font>");
					  $("#kayit").removeAttr("disabled");
				  }else{
					  $(".ogrno").html("<font color=red><b></b>Bu öğrenci numarası ile daha önce kayıt yapılmış!!</font>");
					  $("#kayit").attr("disabled",true);
				  }
//                  $(".status").html(msg);
//              });
		}
	});
});


$('#addogrenci').bootstrapValidator({
    message: 'Bu deger gecerli degil',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	ogrencino: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Ogrenci numarasi gereklidir ve bos birakilamaz'
                },                   
                stringLength: {
                    min: 8,
                    max: 8,
                    message: 'Ogrenci numarasi 8 karakterden olusmalidir'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Ogrenci numarasi sayilardan olusmalidir'
                }
            }
        },
        ad: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message : "Isim gereklidir"
                }
            }
        },
        soyad: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Soyad gereklidir'
                }
                
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: 'E-Posta gereklidir ve bos birakilamaz'
                },
                emailAddress: {
                    message: 'Gecerli bir eposta adresi degil'
                }
            }
        },
        password: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Sifre Gereklidir Bos birakilamaz'
                },
                stringLength: {
                    min: 6,
                    max: 30,
                    message: 'Sifre en az 6  en fazla 30 karakterden olusmalidir'
                },
                identical: {
                    field: 'repeatpassword',
                    message: 'Sifreler uyusmuyor'
                },
            }
        },
        repeatpassword: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Bu alan bos birakilamaz'
                },
                identical: {
                    field: 'password',
                    message: 'Sifreler uyusmuyor'
                }
            }
        },
        
        sinif: {
            validators: {
                notEmpty: {
                    message: 'Lutfen sinifinizi seciniz.'
                }
            }
        },
//        fakulte: {
//            validators: {
//                notEmpty: {
//                    message: 'Lutfen fakultenizi seciniz.'
//                }
//            }
//        },
//        bolum: {
//            validators: {
//                notEmpty: {
//                    message: 'Lutfen bolumunuzu seciniz.'
//                }
//            }
//        },
        ogrenci_img:{
        	message : "Bu alan bos birakilamaz",
        	validators: {
                notEmpty: {
                    message: 'Lutfen resim ekleyiniz'
                },
                file:{
                	extension: 'jpeg,png,jpg',
                    type: 'image/jpeg,image/png',
                    maxSize: 4194304,   // 2048 * 1024
                    message: "Lutfen Resim seciniz."
                }
        	}
        }	
    }
});

$('#ayarlarForm').bootstrapValidator({
    message: 'Bu deger gecerli degil',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        ad: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message : "Isim gereklidir"
                }
            }
        },
        soyad: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Soyad gereklidir'
                }
                
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: 'E-Posta gereklidir ve bos birakilamaz'
                },
                emailAddress: {
                    message: 'Gecerli bir eposta adresi degil'
                }
            }
        },
    	sinif: {
            message: 'Bu alan bos birakilamaz',
            validators: {
                notEmpty: {
                    message: 'Sinif gereklidir ve bos birakilamaz'
                },                   
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Sinif sayilardan olusmalidir'
                }
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

//$('#basvurform').bootstrapValidator({
//    feedbackIcons: {
//        valid: 'glyphicon glyphicon-ok',
//        invalid: 'glyphicon glyphicon-remove',
//        validating: 'glyphicon glyphicon-refresh'
//    },
//    fields: {
//        ders: {
//            validators: {
//                notEmpty : {
//                    message : "Bu alan ders bırakılamaz"
//                }
//            }
//        }
//    }
//    });
});