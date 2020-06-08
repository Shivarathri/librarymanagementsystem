$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/shahensha/Desktop/New folder/project/lmscucumber/src/test/java/com/capgemini/lmscucumber/features/adminBook.feature");
formatter.feature({
  "line": 2,
  "name": "Admin Book Services",
  "description": "",
  "id": "admin-book-services",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.scenarioOutline({
  "line": 10,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Admin enters  \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Book should be \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;",
  "rows": [
    {
      "cells": [
        "bookName",
        "author",
        "category",
        "publisher",
        "status"
      ],
      "line": 16,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;1"
    },
    {
      "cells": [
        "\"jdbc\"",
        "\"James\"",
        "\"Programming\"",
        "\"microsystem\"",
        "\"Book is added\""
      ],
      "line": 17,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6906306000,
  "status": "passed"
});
formatter.before({
  "duration": 5135324300,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin gives \"prasant@gmail.com\", \"Password@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Click on the Admin",
  "keyword": "And "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 1317388500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prasant@gmail.com",
      "offset": 13
    },
    {
      "val": "Password@123",
      "offset": 34
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 994195800,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 8176700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.click_on_the_admin()"
});
formatter.result({
  "duration": 279999000,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Admin enters  \"jdbc\",\"James\",\"Programming\",\"microsystem\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Book should be \"Book is added\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_adding_book()"
});
formatter.result({
  "duration": 307195400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jdbc",
      "offset": 15
    },
    {
      "val": "James",
      "offset": 22
    },
    {
      "val": "Programming",
      "offset": 30
    },
    {
      "val": "microsystem",
      "offset": 44
    }
  ],
  "location": "AdminSteps.admin_enters(String,String,String,String)"
});
formatter.result({
  "duration": 299461200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Book is added",
      "offset": 16
    }
  ],
  "location": "AdminSteps.book_should_be(String)"
});
formatter.result({
  "duration": 532452000,
  "status": "passed"
});
formatter.after({
  "duration": 1807267300,
  "status": "passed"
});
formatter.after({
  "duration": 1245307400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 20,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Admin enters updated values \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Book will be \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Admin is deleting book",
  "keyword": "And "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;",
  "rows": [
    {
      "cells": [
        "bookName",
        "author",
        "category",
        "publisher",
        "status"
      ],
      "line": 26,
      "id": "admin-book-services;admin-is-able-to-update-the-book;;1"
    },
    {
      "cells": [
        "\"jjjjj\"",
        "\"jjjj\"",
        "\"connectivity\"",
        "\"rahul\"",
        "\"updated\""
      ],
      "line": 27,
      "id": "admin-book-services;admin-is-able-to-update-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5431034400,
  "status": "passed"
});
formatter.before({
  "duration": 4773801300,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin gives \"prasant@gmail.com\", \"Password@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Click on the Admin",
  "keyword": "And "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 1061666200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prasant@gmail.com",
      "offset": 13
    },
    {
      "val": "Password@123",
      "offset": 34
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 722992600,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 9992100,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.click_on_the_admin()"
});
formatter.result({
  "duration": 307698300,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Admin enters updated values \"jjjjj\",\"jjjj\",\"connectivity\",\"rahul\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Book will be \"updated\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Admin is deleting book",
  "keyword": "And "
});
formatter.match({
  "location": "AdminSteps.admin_is_updating_book()"
});
formatter.result({
  "duration": 667743100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jjjjj",
      "offset": 29
    },
    {
      "val": "jjjj",
      "offset": 37
    },
    {
      "val": "connectivity",
      "offset": 44
    },
    {
      "val": "rahul",
      "offset": 59
    }
  ],
  "location": "AdminSteps.admin_enters_updated_values(String,String,String,String)"
});
formatter.result({
  "duration": 420021500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "updated",
      "offset": 14
    }
  ],
  "location": "AdminSteps.book_will_be(String)"
});
formatter.result({
  "duration": 306063400,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_deleting_book()"
});
formatter.result({
  "duration": 4437939800,
  "status": "passed"
});
formatter.after({
  "duration": 1151386300,
  "status": "passed"
});
formatter.after({
  "duration": 1365938200,
  "status": "passed"
});
});