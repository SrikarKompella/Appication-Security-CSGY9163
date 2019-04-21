<?php
header("X-XSS-Protection: 0");

$string = $_GET['query'];

echo "=D " . $string;