var express = require('express');
var app = express();
 
// Creates a server which runs on port 3000 and 
// can be accessed through localhost:3000
app.listen(3020, function() {
	console.log('server running on port 3020');
} )
 
// Function callName() is executed whenever 
// url is of the form localhost:3000/name
app.get('/sensor', sensorDataFunction);

function sensorDataFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/RowAddCSV.py"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}

