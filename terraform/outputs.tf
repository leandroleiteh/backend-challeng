output "alb_dns_name" {
  description = "Endpoint publico da aplicação"
  value       = aws_lb.alb.dns_name
}
