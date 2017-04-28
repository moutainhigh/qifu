function xhrSendParameter(xhrUrl, jsonParam, successFn, errorFn) {
	parent.showPleaseWait();
	$.ajax({
		type : _qifu_jqXhrType,
	    url : xhrUrl,
	    timeout: _qifu_jqXhrTimeout,
	    dataType : 'json',
	    data : jsonParam,
	    cache: _qifu_jqXhrCache,
	    async: _qifu_jqXhrAsync,
	    success : function(data, textStatus) {
	    	parent.hidePleaseWait();  	    	
			if (data==null || (typeof data=='undefined') ) {
				alert('Unexpected error!');
				return;
			}    			
			if ( _qifu_success_flag != data.login ) {
				alert("Please try login again!");
				return;
			}       
			if ( _qifu_success_flag != data.isAuthorize ) {
				alert("No permission!");
				return;        				
			}        						
			successFn(data, textStatus);
	    },
	    error : function(jqXHR, textStatus, errorThrown) {
	    	parent.hidePleaseWait(); 	    	
	        alert(textStatus);
	        errorFn(jqXHR, textStatus, errorThrown);
	    }
	});
}

function xhrSendForm(xhrUrl, formId, successFn, errorFn) {
	parent.showPleaseWait();
	$.ajax({
		type : _qifu_jqXhrType,
	    url : xhrUrl,
	    timeout: _qifu_jqXhrTimeout,
	    dataType : 'json',
	    data : $("#"+formId).serialize(),
	    cache: _qifu_jqXhrCache,
	    async: _qifu_jqXhrAsync,
	    success : function(data, textStatus) {
	    	parent.hidePleaseWait();  	    	
			if (data==null || (typeof data=='undefined') ) {
				alert('Unexpected error!');
				return;
			}    			
			if ( _qifu_success_flag != data.login ) {
				alert("Please try login again!");
				return;
			}       
			if ( _qifu_success_flag != data.isAuthorize ) {
				alert("No permission!");
				return;        				
			}        						
			successFn(data, textStatus);
	    },
	    error : function(jqXHR, textStatus, errorThrown) {
	    	parent.hidePleaseWait(); 	    	
	        alert(textStatus);
	        errorFn(jqXHR, textStatus, errorThrown);
	    }
	});
}

function setWarningMessageField(formGroupId, fields, checkFields) {
	if (null == fields) {
		return;
	}
	for (var k in fields) {
		var idKey = '';
		var msgContent = '';
		for (var d in checkFields) {
			if ( fields[k] == d ) {
				idKey = fields[k];
				msgContent = checkFields[d];
			}
		}
		if (null == idKey || idKey == '') {
			continue;
		}
		$("#"+idKey+"-feedback").html( msgContent );
		$("#"+idKey).addClass( "form-control-warning" );		
	}
	$("#"+formGroupId).addClass( "has-warning" );
}
function clearWarningMessageField(formGroupId, fields) {
	for (var k in fields) {
		var idKey = fields[k];
		$("#"+idKey+"-feedback").html( "" );
		$("#"+idKey).removeClass( "form-control-warning" );		
	}
	$("#"+formGroupId).removeClass( "has-warning" );
}
