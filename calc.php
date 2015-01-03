<?php
	$val=$_POST['num'];
    $res=array();
    $res[]="$val + 5";
    $res[]=$val+5;
    echo json_encode($res);
?>