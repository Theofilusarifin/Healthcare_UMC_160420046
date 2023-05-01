<?php
header("Access-Control-Allow-Origin: *");

$arr = null;
$conn = new mysqli("localhost", "hybrid_160420046", "ubaya", "hybrid_160420046");

if ($conn->connect_error) {
    $arr = ["result" => "error", "message" => "unable to connect"];
}

if (!isset($_GET['doctor_id'])) {
    $arr = ["result" => "error", "message" => "doctor_id not provided"];
} else {
    $doctor_id = $_GET['doctor_id'];
    $sql = "SELECT * FROM schedules WHERE doctor_id = '$doctor_id'";

    $stmt = $conn->prepare($sql);
    $stmt->execute();
    $result = $stmt->get_result();

    $data = [];

    if ($result->num_rows > 0) {
        while ($r = mysqli_fetch_assoc($result)) {
            array_push($data, $r);
        }
    }

    echo json_encode($data);

    $stmt->close();
}

$conn->close();
