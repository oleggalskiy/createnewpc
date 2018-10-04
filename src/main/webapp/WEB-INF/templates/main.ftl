<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">


<@c.page>
<div class="row">
    <div class="col-md-2">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-cpu-tab" data-toggle="pill" href="#v-pills-cpu" role="tab" aria-controls="v-pills-home" aria-selected="true">CPU</a>
            <a class="nav-link" id="v-pills-mboard-tab" data-toggle="pill" href="#v-pills-mboard" role="tab" aria-controls="v-pills-profile" aria-selected="false">Motherboard</a>
            <a class="nav-link" id="v-pills-ddr-tab" data-toggle="pill" href="#v-pills-ddr" role="tab" aria-controls="v-pills-messages" aria-selected="false">DDR</a>
            <a class="nav-link" id="v-pills-vga-tab" data-toggle="pill" href="#v-pills-vga" role="tab" aria-controls="v-pills-settings" aria-selected="false">VGA</a>
        </div>
    </div>
    <div class="col-md-6">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-cpu" role="tabpanel" aria-labelledby="v-pills-cpu-tab">
                <table class="table table-hover">
                    <caption>List of CPU</caption>
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Socket</th>
                            <th scope="col">Core</th>
                            <th scope="col">Number of cores</th>
                            <th scope="col">Process tech</th>
                            <th scope="col">Frequency</th>
                            <th scope="col">System bus</th>
                            <th scope="col">Fabricator</th>
                            <th scope="col">Add</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list cpuList?if_exists as cpu>
                        <tr>
                            <th scope="row">${cpu?counter}</th>
                            <td hidden id="idCpu">${cpu.idCpu}</td>
                            <td id="nameCpu">${cpu.nameCPU}</td>
                            <td>${cpu.cpuSocket}</td>
                            <td>${cpu.cpuCore}</td>
                            <td>${cpu.cpuNumberCores}</td>
                            <td>${cpu.cpuProcess} nm</td>
                            <td>${cpu.cpuFrequency} Mgz</td>
                            <td>${cpu.cpuSystemBus}</td>
                            <td>${cpu.cpuFabricator}</td>
                            <td>
                                <button type="button" class="btn btn-outline-info"  id="addCpuBtn">Add</button>
                            </td>
                        </tr>
                        </#list>
                        </tbody>

                    </table>

            </div>
            <div class="tab-pane fade" id="v-pills-mboard" role="tabpanel" aria-labelledby="v-pills-mboard-tab">
                <table class="table table-hover">
                <caption>List of MotherBoard</caption>
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">CPU Socket</th>
                    <th scope="col">Chipset</th>
                    <th scope="col">Memory type</th>
                    <th scope="col">Memory slots</th>
                    <th scope="col">Memory max value</th>
                    <th scope="col">VGA support</th>
                    <th scope="col">Fabricator</th>
                    <th scope="col">Add</th>
                </tr>
                </thead>
                <tbody>
                        <#list mbList?if_exists as mb>
                        <tr>
                            <th scope="row">${mb?counter}</th>
                            <td hidden id="idMb">${mb.idMb}</td>
                            <td id="nameMb">${mb.mbName}</td>
                            <td>${mb.mbCpuSocket}</td>
                            <td>${mb.mbChipset}</td>
                            <td>${mb.mbMemoryType}</td>
                            <td>${mb.mbMemorySlots}</td>
                            <td>${mb.mbMemoryMaxGb} Mgz</td>
                            <td>${mb.mbVgaSup}</td>
                            <td>${mb.mbFabricator}</td>
                            <td>
                                <button type="button" class="btn btn-outline-info"  id="addMbBtn">Add</button>
                            </td>
                        </tr>
                        </#list>
                </tbody>
            </table>
            </div>
            <div class="tab-pane fade" id="v-pills-ddr" role="tabpanel" aria-labelledby="v-pills-ddr-tab">
                <table class="table table-hover">
                <caption>List of DDR</caption>
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">DDR type</th>
                    <th scope="col">Form</th>
                    <th scope="col">Frequency</th>
                    <th scope="col">Size</th>
                    <th scope="col">Fabricator</th>
                    <th scope="col">Add</th>
                </tr>
                </thead>
                <tbody>
                        <#list ddrList?if_exists as ddr>
                        <tr>
                            <th scope="row">${ddr?counter}</th>
                            <td hidden id="idDDR">${ddr.idDdr}</td>
                            <td id="nameDDR">${ddr.ddrName}</td>
                            <td>${ddr.ddrType}</td>
                            <td>${ddr.ddrForm}</td>
                            <td>${ddr.ddrFrequency} Mgz</td>
                            <td>${ddr.ddrSize} Gb</td>
                            <td>${ddr.ddrFabricator}</td>
                            <td>
                                <button type="button" class="btn btn-outline-info" id="addDDRBtn">Add</button>
                            </td>
                        </tr>
                        </#list>
                </tbody>
            </table>
            </div>
            <div class="tab-pane fade" id="v-pills-vga" role="tabpanel" aria-labelledby="v-pills-vga-tab">
                <table class="table table-hover">
                <caption>List of VGA</caption>
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Graph GPU</th>
                    <th scope="col">Frenquency GPU</th>
                    <th scope="col">Interface</th>
                    <th scope="col">Vram</th>
                    <th scope="col">Type Vram</th>
                    <th scope="col">Shaders</th>
                    <th scope="col">Fabricator</th>
                    <th scope="col">Add</th>
                </tr>
                </thead>
                <tbody>
                        <#list vgaList?if_exists as vga>
                        <tr>
                            <th scope="row">${vga?counter}</th>
                            <td hidden id="idVGA">${vga.idVga}</td>
                            <td id="nameVGA">${vga.vgaName}</td>
                            <td>${vga.vgaGraphProc}</td>
                            <td>${vga.vgaFrecProcMhz} Mhz</td>
                            <td>${vga.vgaInterface}</td>
                            <td>${vga.vgaVramMb}</td>
                            <td>${vga.vgaTypeVram}</td>
                            <td>${vga.vgShaders}</td>
                            <td>${vga.vgaFabricator}</td>
                            <td>
                                <button type="button" class="btn btn-outline-info"  id="addVgaBtn">Add</button>
                            </td>
                        </tr>
                        </#list>
                </tbody>
            </table>
            </div>
        </div>
    </div>
    <div class="col-md-2">
        <label for="configForm">PC config</label>
        <form action="/Controller?command=save_pc_config" method="post" id="configForm" name="configForm" >
            <div class="form-group">
                <label for="inputConfigCPU">CPU</label>
                <input type="text" readonly class="form-control form-control-sm" id="inputConfigCPU" value="" placeholder="CPU">
                <input name="pcIdCpu" type="hidden" id="inputConfigIdCPU" value="">
            </div>
            <div class="form-group">
                <label for="inputConfigMBoard">Matherboard</label>
                <input type="text" readonly class="form-control form-control-sm" id="inputConfigMBoard"
                       placeholder="MotherBoard">
                <input name="pcIdMb" type="hidden" id="inputConfigIdMB" value="">
            </div>
            <div class="form-group">
                <label for="inputConfigDDR">DDR</label>
                <input type="text" readonly class="form-control form-control-sm" id="inputConfigDDR" placeholder="DDR">
                <input name="pcIdRam" type="hidden" id="inputConfigIdDDR" value="">
            </div>
            <div class="form-group">
                <label for="inputConfigVGA">VGA</label>
                <input type="text" readonly class="form-control form-control-sm" id="inputConfigVGA" placeholder="VGA">
                <input name="pcIdVga" type="hidden" id="inputConfigIdVGA" value="">
            </div>
            <input name="isActive" type="hidden"  value="true">
            <input name="date" type="hidden" id="pcCreateDate" value="">
            <button type="button" class="btn btn-secondary" id="configSubmitBtn">Submit</button>
        </form >

    </div>
    <div class="col-md-2">
<#if !Session.user??>
         <@l.login/>
</#if>
    </div>
</div>


<#--<#if Session.user??>
<h2>List of pc</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>CREATION DATE</th>
        <th>Author</th>
        <th>isActive</th>
    </tr>
    </thead>
    <tbody>
<#list pcList?if_exists as pc>
<tr>
    <td>${pc.idPC}</td>
    <td>${pc.date}</td>
    <td>${pc.author.username}</td>
    <td>${pc.active?string("Yes","No")}</td>
</tr>
</#list>
    </tbody>
</table>
</#if>-->


</@c.page>