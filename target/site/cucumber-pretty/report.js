$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "LoginFeature",
  "description": "This feature deals with the login functionality of the application",
  "id": "loginfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 8298277794,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the following for Login",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 7
    },
    {
      "cells": [
        "ramanakumar.sai@gmail.com",
        "anupama.413"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I should close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.i_navigate_to_the_login_page()"
});
formatter.result({
  "duration": 4517989922,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.i_enter_the_following_for_Login(DataTable)"
});
formatter.result({
  "duration": 3324728642,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.i_click_login_button()"
});
formatter.result({
  "duration": 6521055348,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "LoginStep.i_should_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});