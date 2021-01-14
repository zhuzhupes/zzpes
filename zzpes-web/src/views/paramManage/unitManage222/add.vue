<template> 
  <product-detail :is-edit='false'></product-detail>
</template>
<script>
  import ProductDetail from './components/ProductDetail'
  import {
    createBrand
  } from '@/api/param/unit'
  export default {
    name: 'addProduct',
    components: { ProductDetail }
  }
</script>
<style>
</style>
