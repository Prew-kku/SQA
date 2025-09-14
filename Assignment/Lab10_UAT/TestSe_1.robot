*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${URL}                D:/SQA_File_test/Starterfiles/Starterfiles/Lab10/Registration.html
${BROWSER}            Chrome

# Locators
${FIRST_NAME_FIELD}   id=firstname
${LAST_NAME_FIELD}    id=lastname
${Organization _FIELD}    id:organization
${EMAIL_FIELD}        id=email
${PHONE_FIELD}        id=phone
${REGISTER_BUTTON}    id=registerButton
${ERRORS}             id=errors
${SUCCESS_FRAGMENT}   Success.html

*** Test Cases ***
TC_001 ไม่ใส่ Register Success
    [Documentation]    Register Success
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri
    Input Text    ${LAST_NAME_FIELD}    Somsri
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    Wait Until Location Contains    Success.html    timeout=10s

    Capture Page Screenshot    TC_001_reg_Success.png
    Close Browser

*** Test Cases ***
TC_002 Register Success No Organization
    [Documentation]    Register Success No Organization
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri
    Input Text    ${LAST_NAME_FIELD}    Somsri
    Clear Element Text    ${ORGANIZATION_FIELD}
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    Wait Until Location Contains    Success.html    timeout=10s

    Capture Page Screenshot    TC_002_Success_No_Org.png
    Close Browser