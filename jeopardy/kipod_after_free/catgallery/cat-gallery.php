<?php
// Dum8_Pa5555w0rd_F0R_7Z
function random($length)
{
    $current = str_shuffle("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")[0];
    if ($length > 0) {
        return $current . random($length - 1);
    }
    return "";
}

if (!isset($_COOKIE["id"])) {
    setcookie("id", random(64), time() + (86400 * 30), "/"); // 86400 = 1 day
}
?>
<!--JaySON is the favorite format even though its not present in this gallery-->
<html>
<head>
    <title>Cat Gallery 2k20</title>
    <script>
        function view(v) {
            let element = get(v);
            let parent = element.parentNode;
            for (let n = 0; n < parent.children.length; n++) {
                hide(parent.children[n]);
            }
            show(element);
        }

        function hide(v) {
            get(v).style.display = "none";
        }

        function show(v) {
            get(v).style.removeProperty("display");

        }

        function get(v) {
            return (typeof "" === typeof v || typeof '' === typeof v) ? document.getElementById(v) : v;
        }
    </script>
</head>
<body onload="view('warn')">
<div id="warn">
    <p>This page is unfiltered and may contain user-uploaded NSFW content.</p>
    <button onclick="view('home')">I understand</button>
</div>
<div id="home">
    <a href="?">Home</a><br/>
    <?php

    if (isset($_GET["new"])) {
        if (isset($_POST["name"]) && isset($_POST["info"])) {
            $name = str_replace(".", "", str_replace("/", "", str_replace("\\", "", $_POST["name"])));
            if (!file_exists("cats/" . $name)) {
                mkdir("cats/" . $name);
                file_put_contents("cats/" . $name . "/info.txt", str_replace("<", "", str_replace(">", "", $_POST["info"])));
                file_put_contents("cats/" . $name . "/id.txt", $_COOKIE["id"]);
                move_uploaded_file($_FILES['image']["tmp_name"], "cats/" . $name . "/pic.png");
                echo "<a href='?cat=$name'>Your cat</a>";
            } else {
                echo "<p>Cat already exists</p>";
            }
        } else {
            echo "<form method='post' action='?new' enctype='multipart/form-data'>";
            echo "<input type='hidden' name='new'/>";
            echo "<input name='name' placeholder='Cat name'/><br/>";
            echo "<input name='info' placeholder='Cat info'/><br/>";
            echo "<input type='file' name='image'/><br/>";
            echo "<input type='submit' value='Add Cat'/>";
            echo "</form>";
        }
    } else if (isset($_GET["cat"])) {
        echo "<p>" . $_GET["cat"] . "</p>";
        echo "<img src='cats/" . $_GET["cat"] . "/pic.png'/><br/>";
        echo "<a href='?info=" . $_GET["cat"] . "'>Info about " . $_GET["cat"] . "</a><br/>";
    } else if (isset($_GET["info"])) {
        // Print Cat Info
        $command = "echo \"" . file_get_contents("cats/" . $_GET["info"] . "/info.txt") . "\";";
        try {
            eval($command);
        } catch (Exception $e) {
        }
    } else {
        // All Cats Mode
        $directories = glob("cats/*", GLOB_ONLYDIR);
        foreach ($directories as $d) {
            $a = explode("/", $d);
            $c = $a[sizeof($a) - 1];
            if (!file_exists("cats/$c/id.txt") || (isset($_COOKIE["id"]) && file_exists("cats/$c/id.txt") && file_get_contents("cats/$c/id.txt") === $_COOKIE["id"]))
                echo "<a href='?cat=$c'><img height='40%' src='cats/$c/pic.png'/></a><br/>";
        }
        echo "<a href='?new'>New Cat</a>";
    }
    ?>
</div>
</body>
</html>