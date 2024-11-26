package com.FoodApplication.Servlet.processPaymentController;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProcessPaymentController extends HttpServlet {

    // Overriding the service method to handle POST requests
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the selected payment method from the form
        String paymentMethod = request.getParameter("paymentMethod");

        // Check if the payment method is selected
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            // If no payment method is selected, set an error message and forward to an error page
            request.setAttribute("error", "Please select a payment method.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentPage.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle different payment methods
            switch (paymentMethod) {
                case "Credit/Debit Card":
                    // Process Credit/Debit Card payment (add logic as per your payment gateway)
                    processCardPayment(request, response);
                    break;
                case "UPI":
                    // Process UPI payment (add logic as per your payment gateway)
                    processUPIPayment(request, response);
                    break;
                case "Cash on Delivery":
                    // Handle Cash on Delivery (COD) method
                    processCOD(request, response);
                    break;
                default:
                    // If payment method is not recognized, forward to error page
                    request.setAttribute("error", "Invalid payment method selected.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("paymentPage.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }

    // Method to process Credit/Debit Card payment
    private void processCardPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add logic to handle Credit/Debit Card payment processing (via a payment gateway)
        // For now, we'll just simulate a successful payment
        request.setAttribute("paymentStatus", "Payment successful using Credit/Debit Card.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentSuccess.jsp");
        dispatcher.forward(request, response);
    }

    // Method to process UPI payment
    private void processUPIPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add logic to handle UPI payment processing (via a payment gateway)
        // For now, we'll just simulate a successful payment
        request.setAttribute("paymentStatus", "Payment successful using UPI.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentSuccess.jsp");
        dispatcher.forward(request, response);
    }

    // Method to process Cash on Delivery (COD)
    private void processCOD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add logic to handle Cash on Delivery processing
        // For now, we'll just simulate a successful payment
        request.setAttribute("paymentStatus", "Payment method selected: Cash on Delivery.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentSuccess.jsp");
        dispatcher.forward(request, response);
    }
}

