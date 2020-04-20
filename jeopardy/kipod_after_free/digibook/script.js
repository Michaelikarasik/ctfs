function next() {
    api("scripts/backend/digibook/digibook.php", "digibook", "next", {id: cookie_pull("id")}, (success, result, error) => {
        content();
        if (success) {
            next()
            get("error").innerText = result;
        } else {
            newSID()
            get("error").innerText = error;
        }
    });
}

function newSID() {
    api("scripts/backend/digibook/digibook.php", "digibook", "id", {}, (success, result, error) => {
        if (success) cookie_push("id", result);
        content();
        next()
    });
}

newSID()