from locust import HttpUser, task

class RecargaUser(HttpUser):

    @task
    def recarga(self):

        self.client.post(
            "/api/recargas",
            json={
                "monto":30000,
                "premium":True
            }
        )