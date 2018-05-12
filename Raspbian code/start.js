var PythonShell = require('python-shell');
var http = require("http");
var express = require("express");
var app = express();
var mysql = require('sync-mysql');
var bodyParser = require('body-parser');

var con = new mysql({
  host: "localhost",
  user: "root",
  password: "",
  database: "mydb"
});

app.use(bodyParser.json());       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
}));
 
// Creates a server which runs on port 3000 and 
// can be accessed through localhost:3000
app.listen(3010, function() {
	console.log('server running on port 3010');
	
} )

//startSensing();
 
// Function callName() is executed whenever 
// url is of the form localhost:3000/name
app.get('/name', callName);
app.get('/sense',startSensing);
app.get('/light', lightFunction);
app.get('/fan', fanFunction);
app.get('/temperatureSensor', temperatureSensorFunction);
app.get('/lightSensor', lightSensorFunction);
app.get('/humanDetectionSensor', humanDetectionSensorFunction);
app.get('/coolingDevice', coolingDeviceFunction);
app.get('/connection', connectionFunction);
app.get('/on', onFunction);
app.get('/off', offFunction);
app.get('/machineLearning', machineLearning)

app.get('/hallDevices', function(req, res) {
	var ans = getHallDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});
app.get('/bedroomDevices', function(req, res) {
	var ans = getBedroomDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});
app.get('/kitchenDevices', function(req, res) {
	var ans = getKitchenDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});
app.get('/guestroomDevices', function(req, res) {
	var ans = getGuestroomDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});
app.get('/bathroomDevices', function(req, res) {
	var ans = getBathroomDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});
app.get('/diningroomDevices', function(req, res) {
	var ans = getDiningroomDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});

app.get('/changeDeviceState', function(req, res) {
	var params = req.query;
	console.log(params);
	var roomID = req.query.roomID;
	var deviceType = req.query.deviceType;
	var status = req.query.status;
	var query = 'UPDATE room SET status="'+status+'" WHERE roomID="'+roomID+'" AND deviceType="'+deviceType+'"';
	con.query(query);
	console.log(query);
	res.end(res.statusCode.toString());
});


/*app.put('/changeDeviceState', function(req, res) {
	var params = req.body;
	console.log(params);
	var roomID = req.body.roomID;
	var deviceType = req.body.deviceType;
	var status = req.body.status;
	var query = 'UPDATE room SET status="'+status+'" WHERE roomID="'+roomID+'" AND deviceType="'+deviceType+'"';
	con.query(query);
	console.log(query);
	res.end(res.statusCode.toString());
});*/


app.get('/getDeviceState', function(req, res) {
	var ans = getDevices(con);
	ans = JSON.stringify(ans);
	console.log(ans);
	res.end(ans);
});


function getHallDevices(con)
{
	var query = "SELECT * from room where roomId=1";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}

function getBedroomDevices(con)
{
	var query = "SELECT * from room where roomId=2";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}

function getKitchenDevices(con)
{
	var query = "SELECT * from room where roomId=3";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}

function getGuestroomDevices(con)
{
	var query = "SELECT * from room where roomId=4";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}

function getBathroomDevices(con)
{
	var query = "SELECT * from room where roomId=5";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}

function getDiningroomDevices(con)
{
	var query = "SELECT * from room where roomId=6";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}


function getDevices(con)
{
	var query = "SELECT * from room";
  	var result = con.query(query);
  	if(result==null)
  	{
     		return;
  	}
  	else
  	{
     		return result;
	}
}



function connectionFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('js',["./query/conn.js"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
		
}

function startSensing(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/testsense.py"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
	})
	//res.end();
}

 
function callName(req, res) {
     
	// Use child_process.spawn method from 
    	// child_process module and assign it
    	// to variable spawn
    	var spawn = require("child_process").spawn;
     
    	// Parameters passed in spawn -
    	// 1. type_of_script
    	// 2. list containing Path of the script
    	//    and arguments for the script 
     
    	// E.g : http://localhost:3000/name?firstname=Mike&lastname=Will
    	// so, first name = Mike and last name = Will
    	var process = spawn('python',["./practise/hello.py",
                            req.query.firstname,
                            req.query.lastname] );
 
    	// Takes stdout data from script which executed
    	// with arguments and send this data to res object
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}


function lightFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/light.py"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
	})
}

function onFunction(req, res) {
     
    	var query = "UPDATE room SET status=1 WHERE roomId="+req.query.room+" AND deviceType="+req.query.deviceId;
  	var result = con.query(query);
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/ON1.py",req.query.room,
                            req.query.deviceId] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
		
    	})
}

function offFunction(req, res) {

	var query = "UPDATE room SET status=0 WHERE roomId="+req.query.room+" AND deviceType="+req.query.deviceId;
  	var result = con.query(query);
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/off.py",req.query.room,
                            req.query.deviceId] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}



function fanFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/Motor3.py",
                            req.query.room,
                            req.query.deviceId,
			    req.query.speed]);
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}


function machineLearning(req, res) {
	
	
	/*PythonShell.run('./Machine_Learning/naive_bayes.py', function (err) {
	    if (err) throw err;
	    console.log('finished');
	});
	console.log ("Now reading data");
	res.send("success");*/
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./Machine_Learning/naive_bayes.py"]);
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
	res.send("success");
}


function temperatureSensorFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./sensor/temperatureSensor.py"]);
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}


function lightSensorFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./sensor/lightSensor.py"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}


function humanDetectionSensorFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./practise/pir.py"] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}


function coolingDeviceFunction(req, res) {
     
    	var spawn = require("child_process").spawn;
    	var process = spawn('python',["./device/coolingDevice.py",
                            req.query.firstname,
                            req.query.lastname] );
    	process.stdout.on('data', function(data) {
        	res.send(data.toString());
    	})
}