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
TC_001 ไม่ใส่ Last Name
    [Documentation]    กรณีไม่ใส่ First Name
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Clear Element Text    ${FIRST_NAME_FIELD}
    Input Text    ${LAST_NAME_FIELD}    Somsri
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter your first name!!    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}

    Capture Page Screenshot    TC_001_reg_missing_Lastname.png
    Close Browser

*** Test Cases ***
TC_002 ไม่ใส่ Last Name
    [Documentation]    กรณีไม่ใส่ Last Name
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri
    Clear Element Text    ${LAST_NAME_FIELD}
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter your last name!!    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}

    Capture Page Screenshot    TC_002_reg_missing_Lastname.png
    Close Browser

*** Test Cases ***
TC_003 ไม่ใส่ First Name Last Name & EMAIL
    [Documentation]    กรณีไม่ใส่ First Name Last Name & EMAIL
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Clear Element Text    ${FIRST_NAME_FIELD}
    Clear Element Text    ${LAST_NAME_FIELD}
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter your name!!    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}

    Capture Page Screenshot    TC_003_reg_missing_FirstName_Lastname.png

    # กรอกข้อมูลอื่น แต่เว้น EMAIL_FIELD ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri_FIRST_NAME
    Input Text    ${LAST_NAME_FIELD}    Somsri_LAST_NAME
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Clear Element Text    ${EMAIL_FIELD}
    Input Text    ${PHONE_FIELD}    081-001-1234

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter your email!!    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}

    Capture Page Screenshot    TC_003_reg_missing_email.png
    Close Browser

*** Test Cases ***
TC_004 ไม่ใส่ phone number
    [Documentation]    กรณีไม่ใส่ phone number
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri_FIRST_NAME
    Input Text    ${LAST_NAME_FIELD}    Somsri_LAST_NAME
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Clear Element Text    ${PHONE_FIELD}

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter your phone number!!    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}

    Capture Page Screenshot    TC_004_reg_missing_number.png
    Close Browser

*** Test Cases ***
TC_005 กรณีใส่ phone number ผิด
    [Documentation]    กรณีใส่ phone number ผิด
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    ${FIRST_NAME_FIELD}    timeout=10s

    # กรอกข้อมูลอื่น แต่เว้น last name ว่าง
    Input Text    ${FIRST_NAME_FIELD}    Somsri_FIRST_NAME
    Input Text    ${LAST_NAME_FIELD}    Somsri_LAST_NAME
    Input Text    ${ORGANIZATION_FIELD}    CS KKU
    Input Text    ${EMAIL_FIELD}    somsri@kkumail.com
    Input Text    ${PHONE_FIELD}    1234

    Click Button    ${REGISTER_BUTTON}

    # ตรวจข้อความที่แสดง (contains เพราะใน HTML มี '*' ข้างหน้า)
    Wait Until Element Contains    ${ERRORS}    Please enter a valid phone number, e.g., 081-234-5678, 081 234 5678, or 081.234.5678)    timeout=5s

    # ตรวจว่าไม่ไปหน้า Success
    ${location}=    Get Location
    Should Not Contain    ${location}    ${SUCCESS_FRAGMENT}
    
    Capture Page Screenshot    TC_005_reg_INV_number.png
    #Close Browser