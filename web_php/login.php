<?php
	include 'connection.php';

	$email = $_POST['email'];
    $password = $_POST['password'];

    
    
    $sql = "Select * from user where email = '$email' and password = '$password'"
    $query = $conn -> query($sql);

    $row = $query -> fetch_array();

    if($row){
        $data = array(
            "email" => $row['email'],
            "password" => $row['password'],
            "name" => $row['name']
        );
        echo json_decode($data);
    }else{
        header('HTTP/1.1 401 login fail');
    }
?>