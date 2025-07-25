terraform {
  required_version = ">= 1.0.0"

  backend "s3" {
    bucket         = "meu-terraform-state-backend"
    key            = "backend-challenge/terraform.tfstate"
    region         = "us-east-1"
    dynamodb_table = "terraform-locks"  # lock remoto via DynamoDB
    encrypt        = true
  }

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 5.79.0, < 7.0"
    }
  }
}
