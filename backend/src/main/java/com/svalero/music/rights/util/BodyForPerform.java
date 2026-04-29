package com.svalero.music.rights.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyForPerform {

    String bodyMusician = """
            {
              "firstName": "Aritz",
              "lastName": "Ontalvilla",
              "birthDate": "1992-09-12",
              "affiliated": true,
              "dni": "45916040J",
              "performanceFee": 6.0,
              "affiliatedNumber": 12313,
              "works": [
                { "id": 999 }
              ]
            }
            """;

    String bodyClaim = """
            {
              "reference": "12345678",
              "status": "open",
              "type": "refund",
              "description": "Reclamacion por derechos en discoteca Oslo",
              "pending": true,
              "musician": {
                "id": 1
              }
            }
            """;

    String bodyConcert = """
            {
              "showTitle": "Concierto en Las Ventas",
              "city": "Madrid",
              "province": "Madrid",
              "date": "2025-06-15",
              "status": "open",
              "performed": false,
              "ticketPrice": 35.50,
              "longitude": -3.688,
              "latitude": 40.416,
              "musician": {
                "id": 1
              }
            } 
            """;

    String bodyDocument = """
            {
              "type": "PDF",
              "filename": "reclamacion_123.pdf",
              "size": 245678,
              "createAt": "2025-02-10",
              "complete": true,
              "completionPercentage": 85.5,
              "claim": {
                "id": 1
              }
            }
            """;

    String bodyWork = """
                {
                  "title": "Little sister",
                  "isrc": "ESABC2370123",
                  "genre": "Stoner",
                  "duration": 2.35,
                  "composedAt": "2023-05-06",
                  "registred": true,
                  "musicians": [
                    { "id": 1 } 
                  ]
                }
            """;
}
