<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
      google.charts.load('current', {'packages':['corechart']});
      
      // ajax호출.
      let centerAry = [];
      centerAry.push(['시도명', '센터갯수'])
      url = "centerChart.do";
      fetch(url)
      .then(result => result.json())
      .then(result => {
        let keys = Object.keys(result);
        let values = Object.values(result);        
        for(let i = 0; i < keys.length; i++){
          centerAry.push([keys[i], values[i]]);
        }
        google.charts.setOnLoadCallback(drawChart);       
        
      })      

	  
      function drawChart() {

        var data = google.visualization.arrayToDataTable(centerAry);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
