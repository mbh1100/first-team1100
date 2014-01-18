<html>
	<head>
    	<title>Team Info</title>
        <meta name="viewport" content="width=device-width; initial-scale=1.0;maximum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="main.css" />
        <script language="javascript">
			function toggle(name)
			{
				var ele = document.getElementById(name);
				if(ele.style.display == "block")
				{
					ele.style.display  = "none";
				}
				else
				{
					ele.style.display = "block";
				}
			}
		</script>
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
    $docname = $_SERVER['QUERY_STRING'];
	try {
			$doc = $client->getDoc($docname);
	 } catch(Exception $e) {
		 
		echo($docname);
		exit(1);
	}
	
	$rounds = array();
	foreach($doc as $key => $value)
	{
		if($key != "_id" && $key != "_rev")
		{
			$value = str_replace('"', '', $value);
			$value = str_replace('{', '', $value);
			$value = str_replace('}', '', $value);
			$roundInfo_t = explode(',', $value);
			$roundInfo = array();
			foreach($roundInfo_t as $element)
			{
				$element = trim($element);
				$set = explode(':', $element);
				
				$roundInfo[$set[0]] = $set[1];
	
			}
			$rounds[$key] = $roundInfo;
		}
	}
	
	echo "<body bgcolor='#cac0a7'>";
	
	echo("<div class='teamList'>");
	
	echo ("<div id='TeamTitle' class='roundHeader'>Team ".$doc->_id."</div>");

    echo "<div id='AggregateInfo'> <ul class='fancyList' style='display:block;'>";
		
		echo "<li><span class='floatRight'>Total Rounds:</span>".count($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Points:</span>".(getAutoPoints($rounds)+getFrisbeePoints($rounds)+getClimbingPoints($rounds))."</li>\n";
		echo "<li><span class='floatRight'>Average Auto Points:</span>".getAutoPoints($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Fisbee Points:</span>".getFrisbeePoints($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Climbing Points:</span>".getClimbingPoints($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Frisbees Collected:</span>".round(getTotalFrisbeesCollected($rounds)  / count($rounds), 2)."</li>\n";
		echo "<li><span class='floatRight'>Total Points Prevented:</span>".getTotalPointsPrevented($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Points Prevented:</span>".round(getTotalPointsPrevented($rounds)  / count($rounds), 2)."</li>\n";
		echo "<li><span class='floatRight'>Total Violations:</span>".getTotalViolations($rounds)."</li>\n";
		echo "<li><span class='floatRight'>Average Defensive Value:</span>".getAverageDefensiveValue($rounds)."</li>\n";

    echo "</ul> </div>";
	
	foreach($rounds as $key => $value)
	{
		echo "<a class='roundHeader' href='javascript:toggle(".$key.");'>"."Round ".$key."</a>";
		echo "<ul  id='".$key."' class='fancyList'>";
		foreach($value as $key2=>$value2)
		{
			echo "<li><span class='floatRight'>".$key2.":</span>".$value2."</li>\n";
		}
		echo "</ul>";
	}
	
	
	function getAutoPoints($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			$points += $value['AutonomousPoints'];
		}
		return round($points / count($rounds), 2);
	}
	
	function getFrisbeePoints($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			$points += $value['Frisbee Points'];
		}
		return round($points / count($rounds), 2);
	}
	
	function getClimbingPoints($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			$points += $value['Climbing Points'];
		}
		return round($points / count($rounds), 2);
	}
	
	function getTotalFrisbeesCollected($rounds)
	{
		$frisbees = 0;
		foreach($rounds as $key => $value)
		{
			$frisbees += $value['Points Prevented'];
		}
		return $frisbees;
	}
	
	function getTotalPointsPrevented($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			$points += $value['Points Prevented'];
		}
		return $points;
	}
	
	function getTotalViolations($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			if($value['Violations'] == "on")
				$points++;
		}
		return $points;
	}
	
	function getAverageDefensiveValue($rounds)
	{
		$points = 0;
		foreach($rounds as $key => $value)
		{
			$points += $value['Defensive Value'];
		}
		$points /= count($rounds);
		$points = round($points, 2);
		return $points;
	}
?>

