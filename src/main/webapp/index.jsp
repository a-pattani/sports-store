<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Sports Online Store - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .hero {
            background: url('./sports.jpg') no-repeat center center;
            background-size: cover;
            color: #fff;
            text-align: center;
            padding: 100px 0;
        }
        .hero h1 {
            font-size: 4rem;
            font-weight: bold;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="#">MySportsOnlineStore</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">Register</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <section class="hero">
        <div class="container">
            <h1>Welcome to Sports Store</h1>
            <p>Explore the latest sports gear and equipment</p>
        <%--    <a href="products.jsp" class="btn btn-primary btn-lg">Shop Now</a> --%>
        </div>
    </section>

    <section class="container my-5">
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img src="./ball.jpg" class="card-img-top" alt="Product Image">
                    <div class="card-body">
                        <h5 class="card-title">Football</h5>
                        <a href="login.jsp" class="btn btn-primary">Login to view</a>
                    </div>
                </div>
            </div>
            <!-- Repeat similar blocks for other products -->
        </div>
    </section>

    <footer class="bg-light text-center py-4">
        <p>&copy; 2024 My Sports Online Store</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
