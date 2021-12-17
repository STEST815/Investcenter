$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Journey.feature");
formatter.feature({
  "name": "Automate Journey 1 and 2",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the application successfully",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs_Journey.i_reached_the_main_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Adviser guide PDF",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I select the find out more button from Charges gadget",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs_Journey.i_select_find_more_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that Charges page is loaded successfully",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs_Journey.i_verify_page_is_loaded(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Charges – SIPP, ISA or GIA download and ensure the PDF is displayed in new window",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs_Journey.i_download_pdf(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Register",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I select the Register icon in top navigation bar",
  "keyword": "When "
});
formatter.step({
  "name": "I verify Adviser registration page is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "I click on continue button leaving the FCA firm reference blank and verify the \u003cmessage\u003e",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "message"
      ]
    },
    {
      "cells": [
        "FSR number field is mandatory. Please try again."
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the application successfully",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs_Journey.i_reached_the_main_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I select the Register icon in top navigation bar",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs_Journey.i_select_register_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify Adviser registration page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs_Journey.i_verify_registration_page_is_loaded()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on continue button leaving the FCA firm reference blank and verify the FSR number field is mandatory. Please try again.",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs_Journey.i_click_continue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Register with random",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I select the Register icon in top navigation bar",
  "keyword": "When "
});
formatter.step({
  "name": "I verify Adviser registration page is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "I click on continue button with \u003crandom-characters\u003e into the FCA firm reference field and verify the \u003cmessage\u003e",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "random-characters",
        "message"
      ]
    },
    {
      "cells": [
        "test",
        "We could not locate your firm. Please check that you have entered your FSR number correctly."
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the application successfully",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs_Journey.i_reached_the_main_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register with random",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I select the Register icon in top navigation bar",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs_Journey.i_select_register_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify Adviser registration page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs_Journey.i_verify_registration_page_is_loaded()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on continue button with test into the FCA firm reference field and verify the We could not locate your firm. Please check that you have entered your FSR number correctly.",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs_Journey.i_click_continue_with_invalid_data(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});