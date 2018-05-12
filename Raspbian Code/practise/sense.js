function startSensing() {
	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/testsense.py"] );
    	process.stdout.on('data', function(data) {
        	
    	})    
}

for (i = 0; i < 100; i++) {
	startSensing();    
}