Commons = {
	notify: function ( message ) {
		$("#messageModal-message")
			.html(message);

		$("#messageModal")
			.modal()
			.show();

		setTimeout(function(){
			$("#messageModal")
				.modal('hide');
		}, 3000);
	},

	request: function( args ){
		args.error = function(){
			console.log( arguments );
			Commons.notify("Não foi possível se comunicar com o servidor, por favor contacte a equipe técnica.");
		};
		if (!args.type )
			args.type = args.data ? "POST" : "GET";
		if (!args.type )
			args.contentType = "application/x-www-form-urlencoded";
		args.contentType+= ";charset=UTF-8";
		$.ajax.call($, args);
	},
	
	requestAsJSON: function( args ){
		args.contentType = "application/json";
		this.request.call(this, args);
	}
};