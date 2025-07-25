terraform {
  required_version = ">= 1.0.0"

  backend "s3" {
    bucket         = "meu-terraform-state-backend"        # ajuste para o nome do seu bucket
    key            = "backend-challenge/terraform.tfstate" # caminho dentro do bucket
    region         = "us-east-1"
    lock_table     = "terraform-locks"                    # nome da sua tabela de locks
    encrypt        = true
  }

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 5.79.0, < 7.0"
    }
  }
}
