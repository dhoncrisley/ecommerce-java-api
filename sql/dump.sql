SET FOREIGN_KEY_CHECKS=0;
# Exporting metadata from `store_java`
DROP DATABASE IF EXISTS `store_java`;
CREATE DATABASE `store_java`;
USE `store_java`;
# TABLE: `store_java`.`cupons`
CREATE TABLE `cupons` (
  `id` varchar(45) NOT NULL,
  `desconto` double(4,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
# TABLE: `store_java`.`hibernate_sequence`
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
# TABLE: `store_java`.`pedidos`
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subtotal` double(13,2) NOT NULL DEFAULT 0.00,
  `total` double(13,2) NOT NULL DEFAULT 0.00,
  `desconto` double(13,2) NOT NULL DEFAULT 0.00,
  `cupom_ativo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pedidos_cupons_idx` (`cupom_ativo`),
  CONSTRAINT `FK_pedidos_cupons` FOREIGN KEY (`cupom_ativo`) REFERENCES `cupons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
# TABLE: `store_java`.`pedido_cupons`
CREATE TABLE `pedido_cupons` (
  `id_pedido` int(11) NOT NULL,
  `id_cupom` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pedido`,`id_cupom`),
  KEY `FK_pedido_cupom_cupom_idx` (`id_cupom`),
  CONSTRAINT `FK_pedido_cupom_cupom` FOREIGN KEY (`id_cupom`) REFERENCES `cupons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pedido_cupom_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
# TABLE: `store_java`.`pedido_produtos`
CREATE TABLE `pedido_produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `valor` double(13,2) NOT NULL,
  `qtd` int(11) NOT NULL,
  `total` double(13,2) NOT NULL,
  `desconto` double(13,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pedido_produtos_produto_idx` (`id_produto`),
  KEY `FK_pedido_produtos_pedidos_idx` (`id_pedido`),
  CONSTRAINT `FK_pedido_produtos_pedidos` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pedido_produtos_produto` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
# TABLE: `store_java`.`produtos`
CREATE TABLE `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `valor` double(13,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
#...done.
SET FOREIGN_KEY_CHECKS=1;
