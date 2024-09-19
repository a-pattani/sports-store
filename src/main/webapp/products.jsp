<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mysportsstore.model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List - My Sports Online Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .hero {
            background: url('./products-hero.jpg') no-repeat center center;
            background-size: cover;
            color: #fff;
            text-align: center;
            padding: 80px 0;
        }
        .hero h1 {
            font-size: 3rem;
            font-weight: bold;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
        .card-img-top {
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            width: 300px;
            height: 300px; /* Adjust this to the desired image height */
            object-fit: cover;
            display: block;
            margin-left: auto;
            margin-right: auto;
}
        .card-body {
            text-align: center;
        }
        .card-title {
            font-size: 1.25rem;
            margin-bottom: 0.5rem;
        }
        .card-text {
            font-size: 1.125rem;
            margin-bottom: 1rem;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 0.5rem 1rem;
            border-radius: 5px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        footer {
            margin-top: auto;
            background-color: #f8f9fa;
            padding: 20px 0;
            text-align: center;
        }
        .products-title {
            text-align: center;
            margin-top: 40px;
            margin-bottom: 40px;
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
                        <a class="nav-link" aria-current="page" href="index.jsp">Home</a>
                    </li>
            <%--        <li class="nav-item">
                        <a class="nav-link active" href="products.jsp">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="register.jsp">Register</a>
                    </li> --%>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class="container my-5">
    <!-- Title for the Products Section -->
    <div class="row">
        <div class="col-12">
            <h2 class="products-title text-center">Our Products</h2>
        </div>
    </div>
    <div class="row">
        <%
            // Fetch the list of products from the request attribute
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="images/products/<%= product.getId() %>.jpg" class="card-img-top" alt="<%= product.getName() %>" style="width: 300px; height: 300px;">
                <div class="card-body">
                    <h5 class="card-title"><%= product.getName() %></h5>
                    <p class="card-text">Rs. <%= product.getPrice() %></p>
                <%--    <a href="product-details.jsp?id=<%= product.getId() %>" class="btn btn-primary">View Details</a> --%>
                </div>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <div class="col-12">
            <p class="text-center">No products found.</p>
        </div>
        <%
            }
        %>
    </div>
</section>

<footer class="bg-light text-center py-4">
    <p>&copy; 2024 My Sports Online Store</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>