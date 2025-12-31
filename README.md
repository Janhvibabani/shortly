# Shortly - URL Shortener

A full-stack URL shortening service built with Spring Boot and React, featuring JWT authentication, rate limiting, and PostgreSQL database.

## Features

- **URL Shortening**: Convert long URLs into short, shareable links
- **User Authentication**: Secure JWT-based authentication system
- **Rate Limiting**: Built-in rate limiting using Bucket4j to prevent abuse
- **User Dashboard**: Manage and track your shortened URLs
- **PostgreSQL Database**: Reliable data persistence
- **RESTful API**: Clean and well-structured API endpoints
- **Docker Support**: Easy deployment with Docker

## Tech Stack

### Backend
- **Spring Boot 3.4.0** - Java 21
- **Spring Security** - Authentication & Authorization
- **Spring Data JPA** - Database operations
- **PostgreSQL** - Primary database
- **JWT (jjwt 0.12.6)** - Token-based authentication
- **Bucket4j** - Rate limiting
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

### Frontend
- **React** - UI framework
- Modern JavaScript/TypeScript

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12+
- Node.js 16+ and npm (for frontend)
- Docker (optional)

## Getting Started

### Backend Setup

1. **Clone the repository**
```bash
git clone https://github.com/Janhvibabani/shortly.git
cd shortly/url-shortener-sb
```

2. **Configure PostgreSQL**

Create a database and update `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/shortly
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Build and run**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
```bash
cd url-shortener-react
```

2. **Install dependencies**
```bash
npm install
```

3. **Start development server**
```bash
npm start
```

The frontend will start on `http://localhost:3000`

## Docker Deployment

Build and run using Docker:

```bash
cd url-shortener-sb
docker build -t shortly-backend .
docker run -p 8080:8080 shortly-backend
```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login user

### URL Operations
- `POST /api/urls/shorten` - Create short URL
- `GET /api/urls` - Get user's URLs
- `GET /{shortCode}` - Redirect to original URL
- `DELETE /api/urls/{id}` - Delete URL

## Project Structure

```
shortly/
├── url-shortener-sb/          # Backend (Spring Boot)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── Dockerfile
└── url-shortener-react/       # Frontend (React)
    ├── src/
    ├── public/
    └── package.json
```

## Security Features

- JWT token-based authentication
- Password encryption
- Rate limiting to prevent abuse
- CORS configuration
- SQL injection prevention via JPA

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the MIT License.

## Author

**Janhvi Babani**
- GitHub: [@Janhvibabani](https://github.com/Janhvibabani)

## Acknowledgments

- Spring Boot team for the excellent framework
- React community for frontend tools
- All contributors and users of this project

---

⭐ Star this repo if you find it helpful!
