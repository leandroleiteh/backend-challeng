variable "region" {
  type    = string
  default = "us-east-1"
}

variable "app_name" {
  type    = string
  default = "quarkus-app"
}

variable "ecr_repo_url" {
  type        = string
  description = "URI do ECR"
  default     = "675080425843.dkr.ecr.us-east-1.amazonaws.com/backend-challenge"
}

variable "desired_count" {
  type    = number
  default = 2
}
