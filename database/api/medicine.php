<?php
header("Access-Control-Allow-Origin: *");

$arr = null;
$conn = new mysqli("localhost", "id20685292_localhost", "Password_!@#4", "id20685292_umc_healthcare");

if ($conn->connect_error) {
    $arr = ["result" => "error", "message" => "unable to connect"];
}


if (isset($_GET['medicine_id'])) {
    $id = $_GET['medicine_id'];
    $sql = "SELECT * FROM medicines WHERE id = '$id'";
} else {
    $sql = "SELECT * FROM medicines";
}

$stmt = $conn->prepare($sql);
$stmt->execute();
$result = $stmt->get_result();

$data = [];

if ($result->num_rows > 0) {
    while ($r = mysqli_fetch_assoc($result)) {
        array_push($data, $r);
    }
}

if (isset($_GET['medicine_id'])) {
    echo json_encode($data[0]);
} else {
    echo json_encode($data);
}

$stmt->close();
$conn->close();
