output "alb_dns_name" {
  description = "Endpoint público da aplicação"
  value       = aws_lb.alb.dns_name
}
