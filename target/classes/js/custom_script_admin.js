$(document).ready(function(){
	

//	$('.collapsed1').collapse();
//	$('.collapsed2').collapse();
//	$('.collapsed3').collapse();
//	$('.collapsed4').collapse();
//	$('.collapsed5').collapse();
//	$('.collapsed6').collapse();
//	$('.collapsed7').collapse();
//	$('.collapsed8').collapse();
//	$('.collapsed9').collapse();
//	$('.collapsed10').collapse();
	
	
//	$("#bolum-select").selectpicker();
//	$("#fakulte-select").selectpicker();
	$(".ders-select").selectpicker();
	$(".derslik-select").selectpicker();
	$(".arastirmagorevlisi1-select").selectpicker();
	$(".arastirmagorevlisi2-select").selectpicker();
	$(".fakulte-select").selectpicker();
	
	// datetimepicker
	 $('#datetimepicker').datetimepicker({
		 language : "tr",
		 minDate : moment().minutes(00),
		 defaultDate : moment().minutes(00),
		 useMinutes : false,
		 showToday: false
	 });
	
	
	$("#deleteOgrenciModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteOgrenci').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteHocaModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteHoca').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteDersModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteDers').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteDerslikModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteDerslik').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteArsgorModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteArsgor').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteBolumModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteBolum').attr('href',$(e.relatedTarget).data('href'));
	});
	$("#deleteFakulteModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteFakulte').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteKuralModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteKural').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteDuyuruModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteDuyuru').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteSinavModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteSinav').attr('href',$(e.relatedTarget).data('href'));
	});
	
//	$("#DagitModal").on('show.bs.modal',function(e){
//		$(this).find('#btnDeleteDuyuru').attr('href',$(e.relatedTarget).data('href'));
//	});
	
	$("#buttonSinav").click(function() {
	    getValueUsingClassDerslik();
	});
	
//	$("#buttondagit").click(function(){
//		var sinavID = ('#btnDagit').val();
//		alert("sinavID : " + sinavID);
//	});
	
	function getValueUsingClassDerslik(){
		var Array = [];
		
		$("#derslikk:checked").each(function() {
			Array.push($(this).val());
		});
		
		var selected;
		selected = Array.join(',');
		
//		if(selected.length > 1){
//			alert("Secilen derslikler " + selected);	
//		}else{
//			alert("Lutfen bir deger seciniz");	
//		}
	}
	
	$("#buttonSinav").click(function() {
	    getValueUsingClassArs();
	});
	
	function getValueUsingClassArs(){
		var chkArray = [];
		
		$("#ars:checked").each(function() {
			chkArray.push($(this).val());
		});
		
		var selected;
		selected = chkArray.join(',');
		
		if(selected.length > 1){
//			alert("Secilen arastirma gorevlileri " + selected);	
		}else{
			alert("Lutfen bir deger seciniz");	
		}
	}
	
	
//$("#derslik").multiselect();

	
//	$("#arastirmagorevlisi").multiselect();
	
//	var values = $("select").val();
	
//	var array_of_checked_values = $("select").multiselect("getChecked").map(function(){
//		   return this.value;    
//		}).get();

	
	
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
  

	$("#EditDuyuruModal").on('show.bs.modal',function(e){
		$(this).find('#duyuruID').val($(e.relatedTarget).data('duyuru-no'));
		$(this).find('#aciklama').val($(e.relatedTarget).data('aciklama'));
	});
	
	$("#EditKuralModal").on('show.bs.modal',function(e){
		$(this).find('#kuralID').val($(e.relatedTarget).data('kural-no'));
		$(this).find('#ad').val($(e.relatedTarget).data('kural-ad'));
	});
	
	$("#EditDerslikModal").on('show.bs.modal',function(e){
		$(this).find('#derslikid').val($(e.relatedTarget).data('derslik-no'));
		$(this).find('#derslikad').val($(e.relatedTarget).data('derslik-ad'));
		$(this).find('#sirasayisi').val($(e.relatedTarget).data('sirasayisi'));
	});
	
	$("#EditDersModal").on('show.bs.modal',function(e){
		$(this).find('#dersID').val($(e.relatedTarget).data('ders-no'));
		$(this).find('#dersad').val($(e.relatedTarget).data('ders-ad'));
	});
	
	$("#EditBolumModal").on('show.bs.modal',function(e){
		$(this).find('#bolumID').val($(e.relatedTarget).data('bolum-no'));
		$(this).find('#bolumad').val($(e.relatedTarget).data('bolum-ad'));
	});
	$("#EditFakulteModal").on('show.bs.modal',function(e){
		$(this).find('#fakulteID').val($(e.relatedTarget).data('fakulte-no'));
		$(this).find('#fakultead').val($(e.relatedTarget).data('fakulte-ad'));
	});
	
	$("#EditHocaModal").on('show.bs.modal',function(e){
		$(this).find('#hocaID').val($(e.relatedTarget).data('hoca-no'));
		$(this).find('#hocaAd').val($(e.relatedTarget).data('hoca-ad'));
		$(this).find('#hocaSoyad').val($(e.relatedTarget).data('hoca-soyad'));
	});
	
	$("#EditArsModal").on('show.bs.modal',function(e){
		$(this).find('#arsgorID').val($(e.relatedTarget).data('arsgor-no'));
		$(this).find('#arsgorAd').val($(e.relatedTarget).data('arsgor-ad'));
		$(this).find('#arsgorSoyad').val($(e.relatedTarget).data('arsgor-soyad'));
	});
	$("#EditSinavModal").on('show.bs.modal',function(e){
		$(this).find('#sinavID').val($(e.relatedTarget).data('sinav-no'));
		$(this).find('#datetimepicker').val($(e.relatedTarget).data('sinav-tarih'));
//		$(this).find('#sinavsaat').val($(e.relatedTarget).data('sinav-saat'));
	});
	
	$('#fakulte').on("change",function(){
		var fakulteNo = $(this).val(); 
		$.ajax({
			url : "getbolum",
			type: "post",
			dataType : "json",
			data : {"fakulteNo" : fakulteNo},
			success : function(data){
				$('#bolum option').remove();
				$('#bbolum').selectpicker('refresh');
				$.each(data.bolum,function(i,item){
					$('#bolum').append($('<option>', {value:item.id, text:item.ad}));
				});
				$('#bolum').prop('disabled',false);
				$('#bolum').selectpicker('refresh');
			}
		});
	});
	
//	$('#dersad').change(function (){
//		var dersad = $(this).val();
//		alert("dersad : " +dersad);
//			$(".ders").html("<img src='image/loading.gif'><font color=gray> kontrol ediliyor...</font>");
//		$.ajax({
//			url : "admin/derskontrol",
//			type : "post",
//			dataType : "json",
//			data : {"dersad" : dersad},
//			success : function(msg){
//				alert("girdim");
//				  $(".status").ajaxComplete(function(event, request){
//					  if(msg == 1){
//						  $(".ders").html("<font color=green><b></b>Uygundur</font>");
//						  $("#dersekle").removeAttr("disabled");
//					  }else{
//						  $(".ders").html("<font color=red><b></b>Bu ders daha önce daha önce eklenmiş!!</font>");
//						  $("#dersekle").attr("disabled",true);
//					  }
//                  $(".status").html(msg);
//	              });
//			}
//		});
//	});
		

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
//	        fakulte: {
//	            validators: {
//	                notEmpty: {
//	                    message: 'Lutfen fakultenizi seciniz.'
//	                }
//	            }
//	        },
//	        bolum: {
//	            validators: {
//	                notEmpty: {
//	                    message: 'Lutfen bolumunuzu seciniz.'
//	                }
//	            }
//	        },
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
	
	$('#dersekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Ders adi gereklidir"
                    }
                }
            }
        }
    });
	
	$('#bolumekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Bolum adi gereklidir"
                    }
                }
            }
        }
    });
	
	$('#fakulteekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Fakulte adi gereklidir"
                    }
                }
            }
        }
    });
	
	$('#duyuruekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Bos birakilamaz"
                    }
                }
            }
        }
    });
	
	$('#kuralekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Bos birakilamaz"
                    }
                }
            }
        }
    });
	
	$('#kuraldegistir').bootstrapValidator({
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
                        message : "Bu alan bos birakilamaz"
                    }
                }
            }
        }
    });
	
	$('#duyurudegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	aciklama: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Bu alan bos birakilamaz"
                    }
                }
            }
        }
    });
	
	$('#hocaekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	username: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Kullanici adi gereklidir'
                    },                   
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'Kullanici adi en az 6 en fazla 30 karakterden olusmalidir'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Kullanici adinda harfler,sayilar ve alt cizgi kullanabilirsiniz'
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
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Isim gereklidir"
                    }
                }
            },
            lastname: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Soyad gereklidir'
                    }
                    
                }
            }
        }
    });
	
	$('#arastirmagorevlisiekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Isim gereklidir"
                    }
                }
            },
            lastname: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Soyad gereklidir'
                    }
                }
            }
        }
    });
	
	$('#sinavekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	tarih: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Sinav Tarihi gereklidir"
                    }
                }
            },
            saat: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Sinav Saati gereklidir'
                    }
                }
            }
        }
    });
	
	$('#derslikekle').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Derslik Adi gereklidir"
                    }
                }
            },
            sirasayisi: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Sira sayisi gereklidir ve bos birakilamaz'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'Sira sayisi sayilardan olusmalidir'
                    }
                }
            }
        }
    });
	
	$('#bolumdegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	bolumad: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Bolum Adi gereklidir"
                    }
                }
            }
        }
    });
	
	$('#sinavdegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	sinavtarih: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Sinav Tarihi gereklidir"
                    }
                }
            },
            sinavsaat: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Sinav Saati gereklidir'
                    }
                }
            }
        }
    });
	
	$('#derslikdegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	derslikad: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Derslik Adi gereklidir"
                    }
                }
            },
            sirasayisi: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Sira sayisi gereklidir ve bos birakilamaz'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'Sira sayisi sayilardan olusmalidir'
                    }
                }
            }
        }
    });
	
	$('#dersdegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	dersad: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Ders adi gereklidir"
                    }
                }
            }
        }
    });
	
	$('#hocadegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	hocaAd: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Isim gereklidir"
                    }
                }
            },
            hocaSoyad: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Soyad gereklidir"
                    }
                }
            }
        }
    });
	
	$('#arastirmagorevlisidegistir').bootstrapValidator({
        message: 'Bu deger gecerli degil',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	arsgorAd: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message : "Isim gereklidir"
                    }
                }
            },
            arsgorSoyad: {
                message: 'Bu alan bos birakilamaz',
                validators: {
                    notEmpty: {
                        message: 'Soyad gereklidir'
                    }
                }
            }
        }
    });
	
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