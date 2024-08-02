/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 96.42857142857143, "KoPercent": 3.5714285714285716};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.5892857142857143, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.5, 500, 1500, "Facilities-1"], "isController": false}, {"data": [1.0, 500, 1500, "Facilities-0"], "isController": false}, {"data": [1.0, 500, 1500, "VisionAndMission-0"], "isController": false}, {"data": [0.5, 500, 1500, "VisionAndMission-1"], "isController": false}, {"data": [1.0, 500, 1500, "Openings-0"], "isController": false}, {"data": [1.0, 500, 1500, "Awards-0"], "isController": false}, {"data": [0.0, 500, 1500, "RegistrationForExam"], "isController": false}, {"data": [0.0, 500, 1500, "Openings-1"], "isController": false}, {"data": [0.5, 500, 1500, "Awards-1"], "isController": false}, {"data": [1.0, 500, 1500, "Library-0"], "isController": false}, {"data": [0.5, 500, 1500, "Library-1"], "isController": false}, {"data": [0.5, 500, 1500, "Homepage-1"], "isController": false}, {"data": [1.0, 500, 1500, "Homepage-0"], "isController": false}, {"data": [0.0, 500, 1500, "Homepage"], "isController": false}, {"data": [0.5, 500, 1500, "Gallery-1"], "isController": false}, {"data": [1.0, 500, 1500, "Gallery-0"], "isController": false}, {"data": [0.5, 500, 1500, "ContactPage-1"], "isController": false}, {"data": [1.0, 500, 1500, "ContactPage-0"], "isController": false}, {"data": [0.5, 500, 1500, "Facilities"], "isController": false}, {"data": [0.5, 500, 1500, "Acadamicpage"], "isController": false}, {"data": [0.5, 500, 1500, "Awards"], "isController": false}, {"data": [0.0, 500, 1500, "Openings"], "isController": false}, {"data": [0.5, 500, 1500, "Gallery"], "isController": false}, {"data": [0.5, 500, 1500, "ContactPage"], "isController": false}, {"data": [0.5, 500, 1500, "Library"], "isController": false}, {"data": [0.5, 500, 1500, "Acadamicpage-1"], "isController": false}, {"data": [0.5, 500, 1500, "VisionAndMission"], "isController": false}, {"data": [1.0, 500, 1500, "Acadamicpage-0"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 28, 1, 3.5714285714285716, 722.5714285714286, 53, 2616, 617.5, 1737.4000000000012, 2590.7999999999997, 2616.0, 2.7507613714510266, 199.94846159986247, 0.5078048248845662], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Facilities-1", 1, 0, 0.0, 631.0, 631, 631, 631.0, 631.0, 631.0, 631.0, 1.5847860538827259, 141.64025356576863, 0.23678932250396195], "isController": false}, {"data": ["Facilities-0", 1, 0, 0.0, 56.0, 56, 56, 56.0, 56.0, 56.0, 56.0, 17.857142857142858, 11.875697544642858, 2.668108258928571], "isController": false}, {"data": ["VisionAndMission-0", 1, 0, 0.0, 54.0, 54, 54, 54.0, 54.0, 54.0, 54.0, 18.51851851851852, 11.881510416666666, 2.5499131944444446], "isController": false}, {"data": ["VisionAndMission-1", 1, 0, 0.0, 604.0, 604, 604, 604.0, 604.0, 604.0, 604.0, 1.6556291390728477, 150.24996119619206, 0.22797237168874174], "isController": false}, {"data": ["Openings-0", 1, 0, 0.0, 55.0, 55, 55, 55.0, 55.0, 55.0, 55.0, 18.18181818181818, 11.736505681818182, 2.5390625], "isController": false}, {"data": ["Awards-0", 1, 0, 0.0, 56.0, 56, 56, 56.0, 56.0, 56.0, 56.0, 17.857142857142858, 11.282784598214285, 2.3716517857142856], "isController": false}, {"data": ["RegistrationForExam", 1, 1, 100.0, 87.0, 87, 87, 87.0, 87.0, 87.0, 87.0, 11.494252873563218, 5.522629310344828, 1.6725035919540232], "isController": false}, {"data": ["Openings-1", 1, 0, 0.0, 2560.0, 2560, 2560, 2560.0, 2560.0, 2560.0, 2560.0, 0.390625, 78.41644287109375, 0.0545501708984375], "isController": false}, {"data": ["Awards-1", 1, 0, 0.0, 1056.0, 1056, 1056, 1056.0, 1056.0, 1056.0, 1056.0, 0.946969696969697, 126.17538914535984, 0.12576941287878787], "isController": false}, {"data": ["Library-0", 1, 0, 0.0, 55.0, 55, 55, 55.0, 55.0, 55.0, 55.0, 18.18181818181818, 11.5234375, 2.432528409090909], "isController": false}, {"data": ["Library-1", 1, 0, 0.0, 581.0, 581, 581, 581.0, 581.0, 581.0, 581.0, 1.721170395869191, 149.10310886402755, 0.23027377366609295], "isController": false}, {"data": ["Homepage-1", 1, 0, 0.0, 1457.0, 1457, 1457, 1457.0, 1457.0, 1457.0, 1457.0, 0.6863417982155113, 62.461795427247765, 0.09718707103637611], "isController": false}, {"data": ["Homepage-0", 1, 0, 0.0, 185.0, 185, 185, 185.0, 185.0, 185.0, 185.0, 5.405405405405405, 3.5103462837837838, 0.7654138513513513], "isController": false}, {"data": ["Homepage", 1, 0, 0.0, 1646.0, 1646, 1646, 1646.0, 1646.0, 1646.0, 1646.0, 0.6075334143377885, 55.68423450789794, 0.17205536148238154], "isController": false}, {"data": ["Gallery-1", 1, 0, 0.0, 869.0, 869, 869, 869.0, 869.0, 869.0, 869.0, 1.1507479861910241, 127.05426495972382, 0.15845260356731874], "isController": false}, {"data": ["Gallery-0", 1, 0, 0.0, 55.0, 55, 55, 55.0, 55.0, 55.0, 55.0, 18.18181818181818, 11.665482954545455, 2.5035511363636362], "isController": false}, {"data": ["ContactPage-1", 1, 0, 0.0, 1122.0, 1122, 1122, 1122.0, 1122.0, 1122.0, 1122.0, 0.8912655971479501, 108.75703264260248, 0.12272309491978609], "isController": false}, {"data": ["ContactPage-0", 1, 0, 0.0, 72.0, 72, 72, 72.0, 72.0, 72.0, 72.0, 13.888888888888888, 8.9111328125, 1.9124348958333335], "isController": false}, {"data": ["Facilities", 1, 0, 0.0, 688.0, 688, 688, 688.0, 688.0, 688.0, 688.0, 1.4534883720930232, 130.87214980014537, 0.4343432049418605], "isController": false}, {"data": ["Acadamicpage", 1, 0, 0.0, 601.0, 601, 601, 601.0, 601.0, 601.0, 601.0, 1.663893510815308, 146.52662229617306, 0.4842190099833611], "isController": false}, {"data": ["Awards", 1, 0, 0.0, 1113.0, 1113, 1113, 1113.0, 1113.0, 1113.0, 1113.0, 0.8984725965858041, 120.28126403863432, 0.23865678346810423], "isController": false}, {"data": ["Openings", 1, 0, 0.0, 2616.0, 2616, 2616, 2616.0, 2616.0, 2616.0, 2616.0, 0.382262996941896, 76.98455717220948, 0.10676486047400612], "isController": false}, {"data": ["Gallery", 1, 0, 0.0, 924.0, 924, 924, 924.0, 924.0, 924.0, 924.0, 1.0822510822510822, 120.1858850784632, 0.2980418019480519], "isController": false}, {"data": ["ContactPage", 1, 0, 0.0, 1194.0, 1194, 1194, 1194.0, 1194.0, 1194.0, 1194.0, 0.8375209380234506, 102.73617436139028, 0.23064541457286433], "isController": false}, {"data": ["Library", 1, 0, 0.0, 636.0, 636, 636, 636.0, 636.0, 636.0, 636.0, 1.5723270440251573, 137.20549577437106, 0.42072032232704404], "isController": false}, {"data": ["Acadamicpage-1", 1, 0, 0.0, 548.0, 548, 548, 548.0, 548.0, 548.0, 548.0, 1.8248175182481752, 159.49867415602188, 0.26552520529197077], "isController": false}, {"data": ["VisionAndMission", 1, 0, 0.0, 658.0, 658, 658, 658.0, 658.0, 658.0, 658.0, 1.5197568389057752, 138.89449563069908, 0.4185267857142857], "isController": false}, {"data": ["Acadamicpage-0", 1, 0, 0.0, 53.0, 53, 53, 53.0, 53.0, 53.0, 53.0, 18.867924528301884, 12.400501179245284, 2.745430424528302], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["404/Not Found", 1, 100.0, 3.5714285714285716], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 28, 1, "404/Not Found", 1, "", "", "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["RegistrationForExam", 1, 1, "404/Not Found", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
