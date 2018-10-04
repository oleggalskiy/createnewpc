$(document).ready( function () {

    function ajaxCallRequest(f_method, f_url, f_data) {
        $.ajax({
            url: f_url,
            type: f_method,
            data: {configPC :f_data}
        });
    }

    $('*#addCpuBtn').on('click', function () {
        var $row = $(this).closest("tr");
        $("#inputConfigCPU").val($row.find("#nameCpu").text());
        $("#inputConfigIdCPU").val($row.find("#idCpu").text());
    });

    $('*#addMbBtn').on('click', function () {
        var $row = $(this).closest("tr");
        $("#inputConfigMBoard").val( $row.find("#nameMb").text());
        $("#inputConfigIdMB").val( $row.find("#idMb").text());
    });

    $('*#addDDRBtn').on('click', function () {
        var $row = $(this).closest("tr");
        $("#inputConfigDDR").val($row.find("#nameDDR").text());
        $("#inputConfigIdDDR").val($row.find("#idDDR").text());
    });

    $('*#addVgaBtn').on('click', function () {
        var $row = $(this).closest("tr");
        $("#inputConfigVGA").val($row.find("#nameVGA").text());
        $("#inputConfigIdVGA").val($row.find("#idVGA").text());
    });

    $("#configSubmitBtn").click(function(event) {
        SetPcCreateDate();
        event.preventDefault();
        var form = $('#configForm');
        var method = form.attr('method');
        var url = form.attr('action');
        var jsonData = {};
        $.each($(form).serializeArray(), function() {
            jsonData[this.name] = this.value;
        });
        var data = JSON.stringify(jsonData);
        alert(data);
        ajaxCallRequest(method, url, data);

    });
    function SetPcCreateDate()
    {
        var dNow = new Date();
        var localdate= (dNow.getFullYear() + '-' +(dNow.getMonth()+1) + '-' + dNow.getDate() + ' ' + dNow.getHours() + ':' + dNow.getMinutes());
        $('#pcCreateDate').val(localdate);
    }
});
