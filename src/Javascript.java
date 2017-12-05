/**
 * Javascript.class
 * @author �̻���, ������, ������, ������
 * 
 * ���� �ۼ���: 2017�� 10�� 25��
 * ���� ������: 2017�� 12�� 7��
 */

public class Javascript {
	
	private String myLocation;									//GuideToSeoul.class �� ���� ���� ����� ��ġ ����
	private String offset;										//(javascript)�⺻ �ɼ�
	private String markers;										//(javascript)��Ŀ (������) �ɼ�
	private String others;										//(javascript)���� �ɼ�
	private String src;											//(javascript)�ʼ� �ɼ�
	
	public Javascript() {
		myLocation = new String("");
		offset = new String("");
		markers = new String("");
		others = new String("");
		src = new String("");
	}
	public String getScript() {									//javascript �ڵ� ��ȯ
		String script = new String(offset+markers+others+src);
		return script;
	}
	
	public void setMain(String place) {
		myLocation = place;
		offset = new String(
				"document.body.style.padding = 0;"+
				"document.body.style.margin = 0;"+
				"var infowindow;\r\n" + 
				"var map;\r\n" + 		
				"var maps = document.getElementById('map');\r\n" + 
  	            "maps.style.width = '100%';\r\n" + 
  	            "maps.style.height = '100%';" +     
  	            "var geocoder;\r\n " +
  	            "var seoul = {lat: 37.566, lng: 126.978};\r\n" + 							//���� �߾� ��ġ �ʱ�ȭ
  	            "function initMap() {\r\n" + 
  	            "	map = new google.maps.Map(document.getElementById('map'), {\r\n" + 		//googeAPI map ���� ����
  	            "       zoom: 12," + 														//zoom ���� 1-20 �� 12����
  	            "       center: seoul"+														//�߾��� ����� ����
  	            "   });\r\n" +	
  	          "var icon1 = {\r\n" + 														//���� ������ �ɼ� ����
				"    url:'https://d30y9cdsu7xlg0.cloudfront.net/png/1363373-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon2 = {\r\n" + 														//����� ������ �ɼ� ����
				"    url: 'https://d30y9cdsu7xlg0.cloudfront.net/png/1363377-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon3 = {\r\n" + 														//�Ĵ� ������ �ɼ� ����
				"    url:'https://d30y9cdsu7xlg0.cloudfront.net/png/1363382-200.png'," + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon4 = {\r\n" + 														//���� ������ �ɼ� ����
				"    url: 'https://d30y9cdsu7xlg0.cloudfront.net/png/1363379-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"
  	            );
		markers = new String("");
  	  
		others = new String(
				"	geocoder = new google.maps.Geocoder();"+								//googleAPI���� �����ϴ� geocoder ��ü ����
  	            "	geocodeAddress(geocoder, map);"+										//�����߾��� �߽����� ���� �浵 ���
  	            "}" +
  	            " function callback(results, status) {\r\n" + 								//��Ŀ�� ���� ������ �Լ�						
  	            "        if (status == google.maps.places.PlacesServiceStatus.OK) {\r\n" + 
  	            "          for (var i = 0; i < results.length; i++) {\r\n" + 
  	            "            createMarker(results[i]);\r\n" + 								//��Ŀ ����
  	            "          }\r\n" + 
  	            "        }\r\n" + 
  	            "      }\r\n" + 
  	            "\r\n" + 
  	            "      function createMarker(place) {\r\n" + 								//��Ŀ ���� �Լ�
  	            "        var placeLoc = place.geometry.location;\r\n" + 
  	            "        var marker = new google.maps.Marker({\r\n" + 
  	            "     	icon: 'http://maps.google.com/mapfiles/kml/pal2/icon28.png',\r\n" + //�ش� URL�� Ŀ���� ������ ���
  	            "          map: map,\r\n" + 												//������ ���̱�
  	            "          position: place.geometry.location\r\n" + 
  	            "        });\r\n" + 
  	            "\r\n" + 
  	            "        google.maps.event.addListener(marker, 'click', function() {\r\n" + 
  	            "          infowindow.setContent(place.name);\r\n" + 
  	            "          infowindow.open(map, this);\r\n" + 
  	            "        });\r\n" + 
  	            "      }" +
  	            "function geocodeAddress(geocoder, resultsMap) {\r\n" + 					//��ɾ�, ���� parameter �� ����
  	            "   var address = \"" + myLocation +"\";" + 								//����� ��ġ �⺻ ��ġ�� ����
  	            "   geocoder.geocode({'address': address}, function(results, status) {\r\n" + 
  	            "      if (status === 'OK') {\r\n" + 
  	            "       resultsMap.setCenter(results[0].geometry.location);\r\n" +
  	            "   	var marker = new google.maps.Marker({\r\n" + 						//����� ��ġ�� ��Ŀ ����
		    	"		animation: google.maps.Animation.DROP," +							//�ִϸ��̼� ȿ�� �߰�
		    	"   	position: results[0].geometry.location,\r\n" + 
		    	"   	icon: 'http://maps.google.com/mapfiles/kml/shapes/man.png',\r\n" + 
				"       map: resultsMap\r\n" + 
				"   	});\n" +
                "      } else {\r\n" + 
  	            "         alert('Geocode was not successful for the following reason: ' + status);\r\n" + 
  	            "      }\r\n" + 
  	            "   });\r\n" + 
  	            "}\r\n" +
  	            " function calculateAndDisplayRoute(directionsService, directionsDisplay) {\r\n" + 
  	            "        directionsService.route({\r\n" + 
  	            "          origin:'seoul',\r\n" + 
  	            "          destination: 'busan',\r\n" + 
  	            "          travelMode: 'DRIVING'\r\n" + 
  	            "        }, function(response, status) {\r\n" + 
  	            "          if (status === 'OK') {\r\n" + 
  	            "            directionsDisplay.setDirections(response);\r\n" + 
  	            "          } else {\r\n" + 
  	            "            window.alert('Directions request failed due to ' + status);\r\n" + 
  	            "          }\r\n" + 
  	            "        });\r\n" + 
  	            "      }"
				);
		
		src = new String("function includeJs(jsFilePath)\r\n" + 							//googleAPI�� javascript �ڵ带 �������� ����Ҽ� �ִ� ���� ����
                "{ var js = document.createElement(\"script\")\r\n" + 
                "\r\n" + 
                "js.type = \"text/javascript\";\r\n" + 
                "js.src = jsFilePath;\r\n" + 
                "\r\n" + 
                "document.body.appendChild(js);\r\n" + 
                "}\r\n" + 
                "includeJs(\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDu5LHktof5c2e81HbeiMy3tm4vIfkEs9c&libraries=places&callback=initMap\");\r\n");
	}
	public void setMarker(String marker , double myLat, double myLng){						//��Ŀ ����
	
		markers = "";
		if(marker.equals("Hospital"))
		{
			for(int i=0; i<Hospital.hospitalCount; i++)										//���� �ɼ�
			{
				double distanceKiloMeter =0;
				
				//������ �ڷ�� ����ڰ� �Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hospital.hospitalLA[i]), Double.parseDouble(Hospital.hospitalLO[i]), "kilometer");	
	  		   	if(distanceKiloMeter <5)													//�Ÿ��� 5km �̸��� ��� ��ǥ ǥ��
	  		   	{
					markers = markers+
			    	"   var h = {lat: "+Hospital.hospitalLA[i]+", lng: "+Hospital.hospitalLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
					"   	position: h,\r\n" + 
					"   	icon: icon1,\r\n" + 
					"       map: map\r\n" + 
					"   });\n";
			  		    
	  		   	}
			}
		}
		else if(marker.equals("Road"))
		{
			for(int i=0; i<Road.roadCount; i++)												//�� �ɼ�
	  	    {
				double distanceKiloMeter =0;
				//������ �ڷ�� ����ڰ� �Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Road.roadLA[i]), Double.parseDouble(Road.roadLO[i]), "kilometer");	
	  		   	if(distanceKiloMeter <5)													//�Ÿ��� 5km �̸��� ��� ��ǥ ǥ��
	  		   	{	
					markers = markers+
			    	"  var h = {lat: "+Road.roadLA[i]+", lng: "+Road.roadLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon2,\r\n" +
			    	"       map: map,\r\n" + 
					"   });\n";
					
	  		   	}
	  	    }
		}
		else if(marker.equals("Restaurant"))
		{
			for(int i=0; i<Restaurant.restaurantCount; i++)									//�Ĵ� �ɼ�
	  	    {
				double distanceKiloMeter =0;												
				//������ �ڷ�� ����ڰ� �Ÿ� ���
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Restaurant.restaurantLA[i]), Double.parseDouble(Restaurant.restaurantLO[i]), "kilometer");	
				if(distanceKiloMeter <5)													//�Ÿ��� 5km �̸��� ��� ��ǥ ǥ��
				{
		  		    markers = markers+
			    	"  var h = {lat: " + Restaurant.restaurantLA[i] +", lng: "+Restaurant.restaurantLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon3,\r\n" + 
			    	"       map: map\r\n" + 
					"   });\n";
		  			
				}
	  	    }
		}
		else if(marker.equals("Hotel"))
		{
			for(int i=0; i<Hotel.hotelCount; i++)											//ȣ�� �ɼ�
	  	    {
				double distanceKiloMeter =0;
				
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hotel.hotelLA[i]), Double.parseDouble(Hotel.hotelLO[i]), "kilometer");	
				if(distanceKiloMeter<5)														//�Ÿ��� 5km �̸��� ��� ��ǥ ǥ��
				{
		  		    markers = markers+
			    	"  var h = {lat: "+Hotel.hotelLA[i]+", lng: "+Hotel.hotelLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon4,\r\n" + 
			    	"       map: map,\r\n" + 
					"   });\n";
				}
	  	    }
		}
	}

	public void setDetailMain(String dstLat, String dstLng)	//ClonedDetailFrame ���� ����� �Լ� javascript�� �ʿ��� �ڵ带 �ѹ��� ����
	{
		offset = new String(		"document.body.style.padding = 0;"+								//���� �ʱ�ȭ
				"document.body.style.margin = 0;"+
				"var infowindow;\r\n" + 
				"var map;\r\n" + 		
				"var maps = document.getElementById('map');\r\n" + 
  	            "maps.style.width = '100%';\r\n" + 
  	            "maps.style.height = '100%';" +     
  	            "var seoul = {lat:"+ dstLat +", lng:"+ dstLng + "};\r\n" + 
  	            "function initMap() {\r\n" + 
  	            "	map = new google.maps.Map(document.getElementById('map'), {\r\n" + 
  	            "       zoom: 13," + 
  	            "       center: seoul"+
  	            "   });\r\n"
  	            );
		markers = new String(
				"   var h = {lat: "+dstLat+", lng: "+ dstLng+"};\r\n" + 							//������ ���� �浵  ����
		    	"   var marker = new google.maps.Marker({\r\n" + 
		    	"	animation: google.maps.Animation.DROP," +
				"   	position: h,\r\n" + 														//���� �浵 ��ġ ����
				"       map: map\r\n" + 															//�ʿ� �ٿ��ֱ�
				"   });\n" +
				"   var h = {lat: "+Double.toString(GuideToSeoul.myLat) +", lng: "+ Double.toString(GuideToSeoul.myLng)+"};\r\n" + //����� ���� �浵 ����
		    	"   var marker = new google.maps.Marker({\r\n" +									//����� ��ġ ��Ŀ ���� 
		    	"	animation: google.maps.Animation.DROP," +	
				"   	position: h,\r\n" + 
				"   	icon: 'http://maps.google.com/mapfiles/kml/shapes/man.png',\r\n" +			//����� ��Ŀ Ŀ����
				"       map: map\r\n" + 
				"   });\n"
				);
		others = new String(
				"  var flightPlanCoordinates = [\r\n" + 											//����� ��ġ�� ������ ��ġ ���� �߱�
				"          {lat: "+dstLat+", lng: "+ dstLng+"},\r\n" + 
				"          {lat: "+Double.toString(GuideToSeoul.myLat) +", lng: "+ Double.toString(GuideToSeoul.myLng)+"}\r\n" + 
				"        ];\r\n" + 
				"        var flightPath = new google.maps.Polyline({\r\n" + 
				"          path: flightPlanCoordinates,\r\n" + 
				"          geodesic: true,\r\n" + 
				"          strokeColor: '#FF0000',\r\n" + 
				"          strokeOpacity: 1.0,\r\n" + 
				"          strokeWeight: 2\r\n" + 
				"        });\r\n" + 
				"\r\n" + 
				"        flightPath.setMap(map);" +													//���� ����
				"}"
				);
		src = new String("function includeJs(jsFilePath)\r\n" + 									//googleAPI�� javascript �ڵ带 �������� ����Ҽ� �ִ� ���� ����
                "{ var js = document.createElement(\"script\")\r\n" + 
                "\r\n" + 
                "js.type = \"text/javascript\";\r\n" + 
                "js.src = jsFilePath;\r\n" + 
                "\r\n" + 
                "document.body.appendChild(js);\r\n" + 
                "}\r\n" + 
                "includeJs(\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDu5LHktof5c2e81HbeiMy3tm4vIfkEs9c&libraries=places&callback=initMap\");\r\n");
	}
}
