<?php
require_once "lib/couch.php";
require_once "lib/couchClient.php";
require_once "lib/couchDocument.php";

$couch_dsn = "http://team1100:team1100@team1100.cloudant.com/";
$couch_db = "scoutingserver";

if(isset($_POST['submit'])) 
{
	$team = $_POST['team'];
	$round = $_POST['round'];
	$ap = $_POST['fp'];
	$fp = $_POST['ap'];
	$cp = $_POST['cp'];
	$fc = $_POST['fc'];
	$pp = $_POST['pp'];
	$dv = $_POST['dv'];
	$violations = $_POST['violations'];
	$comments = $_POST['comments'];

	$client = getClient();
	
	try {
	$databases = $client->listDatabases();
	} catch (Exception $e) {
		echo "An Error Occured when Getting Databases!";
		exit(1);
	}
	
	if(in_array($couch_db, $databases) == false)
	{
	     echo "The Desired Database Doesnt Exist!";
		 exit(1);	
	}
	
	$docname = $team;
	
	try {
		$doc = $client->getDoc($docname);
	} catch(Exception $e) {
		$doc = new stdClass();
		$doc->_id = $docname;
	}
	
	$roundInfo = array("AutonomousPoints"=>$fp,
		"Frisbee Points"=>$ap,
		"Climbing Points"=>$cp,
		"Frisbees Collected"=>$fc,
		"Points Prevented"=>$pp,
		"Defensive Value"=>$dv,
		"Violations"=>$violations,
		"Comments"=>$comments);
	$roundInfo_json = json_encode($roundInfo);
	$id = $round;
	$counter = 1;
	if($doc->$id)
	{
		while(true) {
				
			$newid = $id."(".$counter.")";
			if($doc->$newid)
			{
				
			} else {
				$id = $newid;
				break;
			}
		}
	}
	
	$doc->$id = $roundInfo_json;
	
	try {
		$response = $client->storeDoc($doc);
	} catch(Exception $e) {
		echo "\n\nERROR! Failed To Save Document\n".e.getMessage()."\n";
	}
	
	echo "Thank You For Submitting Round Report! We will automattically Redirect you to entry form within 5 seconds!.";
	
	$url = "ScoutingForm.html";
	echo '<META HTTP-EQUIV=Refresh CONTENT="5; URL='.$url.'">';
}

function getClient()
{
	global $couch_dsn, $couch_db;
	return new couchClient($couch_dsn, $couch_db);	
}
?>