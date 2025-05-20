# 🏏 Cricket Matches API

A Spring Boot REST API that fetches and returns today's cricket matches from [cricketdata.org](https://cricketdata.org/). Includes Swagger/OpenAPI documentation.

---

## 🚀 Features

- Get today's cricket matches using external API
- Uses `RestTemplate` to call cricketdata.org API
- Filters matches happening **today**
- Swagger documentation enabled via SpringDoc

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- REST API
- Swagger/OpenAPI (springdoc-openapi)
- Maven

---

## ⚙️ Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/cricket-matches-api.git
   cd cricket-matches-api

**2. Add your Cricket API Key in application.properties:**
cricket.api.url=https://api.cricketdata.org/v1/match
cricket.api.key=52846a2d-03e4-484e-a8c7-333ff0e120e0

**3. Build and run the application:**
mvn clean install
mvn spring-boot:run

**4. Visit Swagger UI:**
http://localhost:8080/swagger-ui/index.html
**
**5. 🔗 API Endpoints****
GET /api/matches/today
Fetch today's cricket matches from the external API.

✅ Response:
[
  {
    "name": "India vs Australia",
    "date": "2025-05-18",
    "venue": "Wankhede Stadium",
    "matchStarted": true
  },
  ...
]

**6. ❌ Error Example:**
If external API fails or is unreachable:

{
  "error": "Unable to fetch match data at this time."
}

**📄 Swagger/OpenAPI
Swagger UI is available at:**

📍 http://localhost:8080/swagger-ui/index.html
📄 http://localhost:8080/v3/api-docs (OpenAPI spec)

**📚 Project Structure**

com.example.cricketmatches
├── controller
│   └── MatchController.java
├── service
│   └── MatchService.java
├── model
│   └── MatchDTO.java
└── CricketMatchesApplication.java

**🛡️ License
MIT License**

🙋‍♂️ Contact
For questions or feedback, please contact [sahukusaroj56@gmail.com]


---

### ✅ What's Next?

- ✅ Add more endpoints (e.g., upcoming matches, match details)
- ✅ Add unit tests
- ✅ Handle edge cases (e.g., rate limit, no data)
- ✅ Dockerize the app (optional)

Would you like me to also generate this README as a downloadable file?



