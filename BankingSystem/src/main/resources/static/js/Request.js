window.onload = function () {
    bankcard();
    historyBill();
    getLoan();
}

function bankcard() {
    $.ajax({
        url: '/bankCardList',
        type: 'post',
        dataType: "json",
        error: function (data) {
            alert('Bank card list request failed');
        },
        success: function (data) {
            $("#bankCardList").empty();
            $("#bankCardListDeposit").empty();
            $("#bankCardListWithdraw").empty();
            $("#bankCardListTransfer").empty();
            for (var i = 0; i < data.length; i++) {
                let str = "<div class=\"row\">" +
                    "<div class =\"col-xs-2\">" + data[i].userName + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].bank + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].bankCardNumber + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].userId + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].remainingBalance + "</div>" +
                    "<div class=\"col-xs-2\">";
                $("#bankCardManageList").append(str +
                    "<button class=\"btn btn-success btn-xs\" onclick=\"getBankcardNumber(this)\" data-target=\"#modifyBankCard\" data-toggle=\"modal\">" +
                    "Modify" +
                    "</button>" +
                    "<button class = \"btn btn-danger btn-xs\" onclick=\"getBankcardNumber(this)\" data-target=\"#deleteBankCard\" data-toggle=\"modal\">" +
                    "Delete" +
                    "</button>" +
                    "</div>" +
                    "</div>");

                $("#bankCardListDeposit").append(str +
                    "<button class=\"btn btn-success btn-xs\" onclick=\"getBankcardNumber(this)\" data-target=\"#reviseSchool\" data-toggle=\"modal\">" +
                    "Deposit" +
                    "</button>" + "</div>" +
                    "</div>");

                $("#bankCardListWithdraw").append(str +
                    "<button class=\"btn btn-success btn-xs\" onclick=\"getBankcardNumber(this)\" data-target=\"#withdrawMoney\" data-toggle=\"modal\">" +
                    "Withdraw" +
                    "</button>" + "</div>" +
                    "</div>");

                $("#bankCardListTransfer").append(str +
                    "<button class=\"btn btn-success btn-xs\" onclick=\"getBankcardNumber(this)\" data-target=\"#transferDetial\" data-toggle=\"modal\">" +
                    "Transfer" +
                    "</button>" + "</div>" +
                    "</div>");
            }
        }
    });
}

function getBankcardNumber(obj) {
    window.bankcardManageNumber = obj.parentNode.parentNode.children.item(2).textContent;
    window.remainingBalance = obj.parentNode.parentNode.children.item(4).textContent;
}

function getBillInformation(param) {
    window.billBalance = param.parentNode.parentNode.children.item(5).textContent;
    window.billType = param.parentNode.parentNode.children.item(0).textContent;
}

function historyBill() {
    $.ajax({
        url: '/historyBillList',
        data: {},
        dataType: 'json',
        type: 'get',
        error: function (data) {
            alert("History bill record query failed!!!")
        },
        success: function (data) {
            $("#historyBillList").empty();
            for (var i = 0; i < data.length; i++) {
                let str = "<div class=\"row\">" +
                    "<div class =\"col-xs-2\">" + data[i].type + "</div>" +
                    "<div class =\"col-xs-1\">" + data[i].senderName + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].sender + "</div>" +
                    "<div class =\"col-xs-1\">" + data[i].payeeName + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].payee + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].value + "</div>" +
                    "<div class=\"col-xs-1\">" +
                    "<button class=\"btn btn-danger btn-xs\" onclick=\"getBillInformation(this)\" data-target=\"#deleteHistory\" data-toggle=\"modal\">" +
                    "Delete Record" +
                    "</button>" +
                    "</div>" +
                    "</div>";
                $("#historyBillList").append(str);
            }
        }
    });
}

function changeSingle() {
    const changeSingleValue = document.getElementById("changeSingleValue").value;

    if (state === "name") {
        $.ajax({
            url: '/changeNameSingle',
            data: {
                "newNameSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to change name!!!")
            },
            success: function (data) {
                alert("Name changed successfully")
            }
        });
    } else if (state === "address") {
        $.ajax({
            url: '/changeAddressSingle',
            data: {
                "newAddressSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to change address!!!")
            },
            success: function (data) {
                alert("Address changed successfully")
            }
        });
    } else if (state === "phoneNumber") {
        $.ajax({
            url: '/changeTelephoneNumberSingle',
            data: {
                "newTelephoneNumberSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to change telephone number!!!")
            },
            success: function (data) {
                alert("Telephone number changed successfully")
            }
        });
    } else {
        alert("Some unknown error occurred");
    }
    document.getElementById("changeSingleValue").value = "";
}

function changeMultiple() {
    const newNameMultiple = document.getElementById("newNameMultiple").value;
    const newAddressMultiple = document.getElementById("newAddressMultiple").value;
    const newTelephoneNumberMultiple = document.getElementById("newTelephoneNumberMultiple").value;
    $.ajax({
        url: '/changeMultiple',
        data: {
            "newNameMultiple": newNameMultiple,
            "newAddressMultiple": newAddressMultiple,
            "newTelephoneNumberMultiple": newTelephoneNumberMultiple
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("Failed to modify multiple information!!!")
        },
        success: function (data) {
            alert("Multiple information modified successfully")
        }
    });
    document.getElementById("changeSingleValue").style.display = "false";
}

function changePassword() {
    const oldPassword = document.getElementById("oldPassword").value;
    const newPassword = document.getElementById("newPassword").value;
    const repeatPassword = document.getElementById("repeatPassword").value;

    if (newPassword === repeatPassword) {
        $.ajax({
            url: '/changePassword',
            data: {
                "oldPassword": oldPassword,
                "newPassword": newPassword,
                "repeatPassword": repeatPassword
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to change password!!!")
            },
            success: function (data) {
                alert("Password changed successfully")
            }
        });
    } else {
        alert("Passwords do not match");
        document.getElementById("newPassword").value = "";
        document.getElementById("repeatPassword").value = "";
    }
}

function changeBankcardPassword() {
    const newPassword = document.getElementById("modifyBankCardPassword").value;
    const repeatPassword = document.getElementById("modifyRepeatBankCardPassword").value;

    if (newPassword === repeatPassword) {
        $.ajax({
            url: '/changeBankcardPassword',
            data: {
                "bankcardNumber": window.bankcardManageNumber,
                "newPassword": newPassword,
                "repeatPassword": repeatPassword
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to change password for card number: " + window.bankcardManageNumber + "!!!")
            },
            success: function (data) {
                alert("Password changed successfully for card number: " + window.bankcardManageNumber)
            }
        });
    } else {
        alert("Passwords do not match");
        document.getElementById("modifyBankCardPassword").value = "";
        document.getElementById("modifyRepeatBankCardPassword").value = "";
    }
}

function deleteBankcard() {
    $.ajax({
        url: '/deleteBankcard',
        data: {
            "bankcardNumber": window.bankcardManageNumber
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("Failed to delete bank card with number: " + window.bankcardManageNumber + "!!!")
        },
        success: function (data) {
            alert("Bank card deleted successfully: " + window.bankcardManageNumber)
        }
    });
}

function depositMoney() {
    const number = document.getElementById("depositNumber").value;
    $.ajax({
        url: '/depositMoney',
        data: {
            "bankcardNumber": window.bankcardManageNumber,
            "number": number
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("Failed to deposit to card number: " + window.bankcardManageNumber + "!!!")
        },
        success: function (data) {
            alert("Successfully deposited " + number + " yuan to card number: " + window.bankcardManageNumber)
        }
    });
}

function withdrawMoney(obj) {
    const number = document.getElementById("withdrawNumber").value;
    if (parseFloat(window.remainingBalance) >= parseFloat(number)) {
        $.ajax({
            url: '/withdrawNumber',
            data: {
                "bankcardNumber": window.bankcardManageNumber,
                "number": number
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("Failed to withdraw from card number: " + window.bankcardManageNumber + "!!!")
            },
            success: function (data) {
                alert("Successfully withdrew " + number + " yuan from card number: " + window.bankcardManageNumber)
            }
        });
    } else {
        alert("Insufficient balance!!");
    }
}

function deleteHistoryBill() {
    $.ajax({
        url: '/deleteHistoryBill',
        data: {
            "balance": window.billBalance,
            "type": window.billType
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("Failed to delete order!!!")
        },
        success: function (data) {
            alert("Order deleted successfully!!!")
        }
    });
}

function transferMoney() {
    const transferNumber = document.getElementById("transferNumber").value;
    const receiverBankCardNumber = document.getElementById("receiverBankCardNumber").value;

    if (parseFloat(window.remainingBalance) >= parseFloat(transferNumber)) {
        $.ajax({
            url: '/transferMoney',
            data: {
                "sender": window.bankcardManageNumber,
                "money": transferNumber,
                "payee": receiverBankCardNumber
            },
            dataType: "text",
            type: "get",
            error: function (data) {
                alert("Transfer failed");
            },
            success: function (data) {
                alert("Transfer successful");
            }
        });
    } else {
        alert("Insufficient balance!!");
    }
}

function addBankCard() {
    const newPassword = document.getElementById("addBankCardPassword").value;
    const repeatPassword = document.getElementById("addBankCardRepeatPassword").value;
    const addBankCardNumber = document.getElementById("addBankCardNumber").value;
    const obj = document.getElementById("bankSelect");
    const index = obj.selectedIndex;
    const bank = obj.options[index].text;

    if (newPassword === repeatPassword) {
        $.ajax({
            url: '/addBankCard',
            data: {
                "newPassword": newPassword,
                "addBankCardNumber": addBankCardNumber,
                "bank": bank
            },
            dataType: "text",
            type: "get",
            error: function (data) {
                alert("Add failed");
            },
            success: function (data) {
                alert("Add successful");
            }
        });
    } else {
        alert("Passwords do not match");
        document.getElementById("addBankCardPassword").value = "";
        document.getElementById("addBankCardRepeatPassword").value = "";
    }
}

function getLoan() {
    $.ajax({
        url: '/getLoan',
        type: 'post',
        dataType: "json",
        error: function (data) {
            alert('Loan list request failed');
        },
        success: function (data) {
            $("#loanTable").empty();
            if (data.length > 0) {
                var str = "<tr>" +
                    "<td className=\"col-xs-2\" rowSpan=\"" + data.length + "\" valign=\"middle\">Loan</td>" +
                    "<td className=\"col-xs-3\" style=\"padding-left: 20px;\">" + data[0].name + "</td>" +
                    "<td className=\"col-xs-2\" style=\"padding-left: 20px;\">" + data[0].interestrate + "</td>" +
                    "<td className=\"col-xs-2\" style=\"padding-left: 2px;\">" + data[0].detial + "</td>" +
                    "<td className=\"col-xs-3\">" +
                    "<a aria-controls=\"char\" className=\"linkCcc\" data-toggle=\"tab\" href=\"#LoanDetial\"" +
                    "role=\"tab\">Details</a>" +
                    "</td>" +
                    " </tr>";
                $("#loanTable").append(str);
            }
            for (var i = 1; i < data.length; i++) {
                let str1 = "<tr>" +
                    "<td className=\"col-xs-3\"style=\"padding-left: 20px;\">" + data[i].name + " </td>" +
                    "<td className=\"col-xs-2\"style=\"padding-left: 20px;\">" + data[i].interestrate + "</td>" +
                    "<td className=\"col-xs-2\"style=\"padding-left: 2px;\">" + data[i].detial + "</td>" +
                    "<td className=\"col-xs-3\">" +
                    "<a aria-controls=\"char\" className=\"linkCcc\" data-toggle=\"tab\" href=\"#LoanDetial\"" +
                    "role=\"tab\">Details</a>" +
                    "</td>" +
                    " </tr>";
                $("#loanTable").append(str1);
            }
        }
    });
}

function getLoanMoney() {
    const bankcardNumber = document.getElementById("LoanBankcard").value;
    const money = document.getElementById("loanNumber").value;
    $.ajax({
        url: "/getLoanMoney",
        type: "get",
        dataType: "text",
        data: {
            "bankcardNumber": bankcardNumber,
            "money": money
        },
        error: function (data) {
            alert('Loan failed');
        },
        success: function (data) {
            alert('Loan successful');
        }
    });
}