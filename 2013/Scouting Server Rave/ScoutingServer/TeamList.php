<html>
	<head>
    	<title>Team List</title>
        <link rel="stylesheet" type="text/css" href="main.css" />
        <meta name="viewport" content="width=device-width; initial-scale=1.0;maximum-scale=1.0">
    </head>
    
	<body>
<?php
    $couch_dsn = "http://team1100:team1100@team1100.cloudant.com/";
    $couch_db = "scoutingserver";
    
    require_once "../lib/couch.php";
    require_once "../lib/couchClient.php";
    require_once "../lib/couchDocument.php";
    
    $table = 'Teams';
    
    $client = new couchClient($couch_dsn, $couch_db);
    $query="teams";
    $info = $client->getView('teamList', $query);
	$field_count = count($info->rows);
	
	echo "<body bgcolor='#cac0a7'>";
	
	echo("<div class='teamList'>");
	echo "<ul class='fancyList' style=\"display:block;\">";
	for($i=$field_count-1; $i>=0; $i--)
	{
		echo "<li style='font-size:50px; text-align:center;'>"."<a href=TeamInfo.php?".$info->rows[$i]->id.">"."Team ".$info->rows[$i]->id."</li>\n";
	}
	
?>